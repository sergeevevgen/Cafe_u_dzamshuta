package com.cafe.cafe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @OneToOne
    @JoinColumn(name = "order_fk")
    private Order order;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_fk")
    private List<Message> messageList;
}
