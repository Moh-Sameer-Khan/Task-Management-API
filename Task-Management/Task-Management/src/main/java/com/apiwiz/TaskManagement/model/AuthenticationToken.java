package com.apiwiz.TaskManagement.model;


import com.apiwiz.TaskManagement.model.enums.TokenUserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AuthenticationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tokenId;
    private String tokenValue;
    private LocalDateTime tokenCreationDateTime;

    @Enumerated(value = EnumType.STRING)
    private TokenUserType tokenUserType;

    //mapping
    @OneToOne
    @JoinColumn(name = "fk_token_user_id")
    private User tokenOwner;

    //create a parameterized constructor which takes user as an argument
    public AuthenticationToken(User existingUser) {
        this.tokenOwner = existingUser;
        this.tokenValue = UUID.randomUUID().toString();
        this.tokenCreationDateTime = LocalDateTime.now();
    }

    private Integer tokenUserId;
    public AuthenticationToken(TokenUserType type,Integer id){
        this.tokenUserType = type;
        this.tokenUserId = id;
        this.tokenCreationDateTime = LocalDateTime.now();
        tokenValue = UUID.randomUUID().toString();
    }
}
