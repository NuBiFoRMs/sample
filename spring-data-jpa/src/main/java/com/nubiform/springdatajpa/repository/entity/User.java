package com.nubiform.springdatajpa.repository.entity;

import lombok.*;

import javax.persistence.Column;
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
    @Column(length = 20)
    private String username;
    @Column(length = 20)
    private String password;
    @Column(length = 100)
    private String email;
    private boolean enabled;
}
