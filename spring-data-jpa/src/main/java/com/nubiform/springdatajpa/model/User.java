package com.nubiform.springdatajpa.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    private String username;
    private String password;
    private String email;
    private boolean enabled;
}
