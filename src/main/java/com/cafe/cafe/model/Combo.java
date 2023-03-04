package com.cafe.cafe.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Combo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String description;

    private String image_url;

    @Transient
    private Double sale;

    @NotBlank
    @Column(nullable = false)
    private Double price;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "combo_fk")
    private List<Product> products = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_fk")
    private Order order;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Double getSale() {
        return sale;
    }

    public void setSale(Double sale) {
        this.sale = sale;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void updateProduct(Product product) {
        for (var m : products) {
            if (Objects.equals(m.getId(), product.getId())) {
                m = product;
                return;
            }
        }
    }
    public Product removeProduct(Long id) {
        for (var p : products) {
            if (Objects.equals(p.getId(), id)) {
                products.remove(p);
                return p;
            }
        }
        return null;
    }

    public void setProduct(Product product) {
        if (!products.contains(product)) {
            products.add(product);
            if (product.getCombo() != this) {
                product.setCombo(this);
            }
        }
    }

    public void setOrder(Order order) {
        this.order = order;
        if (!order.getCombos().contains(this)) {
            order.setCombo(this);
        }
    }

    public void removeOrder() {
        order.removeCombo(getId());
        order = null;
    }

    public Order getOrder() {
        return order;
    }
}
