package data.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    //Done
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

    //Done
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_fk")
    private Chat chat;

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

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
        if (!chat.getMessages().contains(this)) {
            chat.setMessage(this);
        }
    }

    public void removeChat() {
        chat.removeMessage(getId());
        chat = null;
    }
}
