package com.cafe.cafe.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

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

    private Long weight;

    private Double price;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Order_Item> product_orderList;

    @ManyToOne()
    private ProductCategory productCategory;
}
