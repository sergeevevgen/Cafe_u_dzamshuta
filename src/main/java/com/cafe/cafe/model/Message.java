package com.cafe.cafe.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
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
    @JoinColumn(name = "chat_fk")
    private Chat chat;
}
