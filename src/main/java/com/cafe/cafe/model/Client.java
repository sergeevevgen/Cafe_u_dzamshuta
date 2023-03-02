package com.cafe.cafe.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    //Done
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String surname;

    @NotBlank
    @Column(nullable = false)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String password;

    @NotBlank
    @Column(nullable = false)
    private String address;

    //Done
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_fk")
    private List<Order> orders = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setOrder(Order order){
        if(!orders.contains(order))
        {
            orders.add(order);
            if(order.getClient() != this)
            {
                order.setClient(this);
            }
        }
    }

    public Order removeOrder(Long orderId) {
        for (var order : orders) {
            if (Objects.equals(order.getId(), orderId)){
                orders.remove(order);
                return order;
            }
        }
        return null;
    }

    public void removeAllOrders() {
        orders.clear();
    }

    public void updateOrder(Order o) {
        for (var order : orders) {
            if(Objects.equals(order.getId(), o.getId())) {
                order = o;
                return;
            }
        }
    }
}
