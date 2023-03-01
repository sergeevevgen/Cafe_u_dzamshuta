package com.cafe.cafe.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String text;

    @NotBlank
    @Column(nullable = false)
    private Long time;

    @NotBlank
    @Column(nullable = false)
    private Long first_sender_id;

    @NotBlank
    @Column(nullable = false)
    private Long second_sender_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_fk")
    private Order order;

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getFirst_sender_id() {
        return first_sender_id;
    }

    public void setFirst_sender_id(Long first_sender_id) {
        this.first_sender_id = first_sender_id;
    }

    public Long getSecond_sender_id() {
        return second_sender_id;
    }

    public void setSecond_sender_id(Long second_sender_id) {
        this.second_sender_id = second_sender_id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
        if (!order.getMessages().contains(this)) {
            order.setMessage(this);
        }
    }

    public void removeOrder() {
        if (order.removeMessage(getId()) != null) {
            order.removeMessage(getId());
        }
        order = null;
    }

    @Override
    public String toString() {
        return "Message{" +
                "text='" + text + '\'' +
                ", time=" + time +
                ", first_sender_id=" + first_sender_id +
                ", second_sender_id=" + second_sender_id +
                ", order=" + order +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(id, message.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, time, first_sender_id, second_sender_id, order);
    }
}
