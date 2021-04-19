package com.example.photography_shop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String login;
    private Long phoneNumber;
    private String activatedCode;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;


}

