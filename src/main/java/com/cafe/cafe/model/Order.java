package com.cafe.cafe.model;

import com.cafe.cafe.model.enums.Order_Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Order_Status status;

    private Double price;

    @Transient
    private Integer count;

    //done
    @ManyToOne
    @JoinColumn(name = "client_fk")
    private Client client;

    //done
    @ManyToOne
    @JoinColumn(name = "deliveryman_fk")
    private DeliveryMan deliveryMan;

    @NotBlank
    @Column(nullable = false)
    private String title;

    //done, messages will delete when order
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_fk")
    private List<Message> messages = new ArrayList<>();

    //done, items will delete when order
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<Order_Item> items = new ArrayList<>();

    public void updateMessage(Long id, Message message) {
        for (var m : messages) {
            if (Objects.equals(m.getId(), message.getId())) {
                m = message;
                return;
            }
        }
    }
    public Message removeMessage(Long id) {
        for (var message : messages) {
            if (Objects.equals(message.getId(), id)) {
                messages.remove(message);
                return message;
            }
        }
        return null;
    }

    public void setMessage(Message message) {
        if (!messages.contains(message)) {
            messages.add(message);
            if (message.getOrder() != this) {
                message.setOrder(this);
            }
        }
    }

    public Long getId() {
        return id;
    }

    public Order_Status getStatus() {
        return status;
    }

    public void setStatus(Order_Status status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
        if (!client.getOrders().contains(this)) {
            client.setOrder(this);
        }
    }

    public void removeClient() {
        client.removeOrder(getId());
        client = null;
    }

    public void removeDeliveryMan() {
        deliveryMan.removeOrder(getId());
        deliveryMan = null;
    }

    public DeliveryMan getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(DeliveryMan deliveryMan) {
        this.deliveryMan = deliveryMan;
        if (!deliveryMan.getOrders().contains(this)) {
            deliveryMan.setOrder(this);
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Integer getCount() {
        int k = 0;
        for (var i : items) {
            k += i.getCount();
        }
        return k;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status=" + status +
                ", price=" + price +
                ", client=" + client +
                ", deliveryMan=" + deliveryMan +
                ", title='" + title + '\'' +
                ", messages=" + messages +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, price, client, deliveryMan, title, messages);
    }


}
