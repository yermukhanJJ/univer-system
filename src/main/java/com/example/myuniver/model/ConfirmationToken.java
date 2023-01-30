package com.example.myuniver.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "confirmationtoken")
public class ConfirmationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "token")
    private String token;
    @Column(name = "createat")
    private LocalDateTime createAt;
    @Column(name = "expiresat")
    private LocalDateTime expiresAt;
    @Column(name = "confirmedat")
    private LocalDateTime confirmedAt;

    @Transient
    @OneToOne
    private Users user;

    public ConfirmationToken(String token, LocalDateTime createAt, LocalDateTime expiresAt, Users user) {
        this.token = token;
        this.createAt = createAt;
        this.expiresAt = expiresAt;
        this.user = user;
    }
}
