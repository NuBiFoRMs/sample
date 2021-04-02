package com.nubiform.springdatajpa.model;

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
    private String name;
    @Column(length = 20)
    private String password;
    @Column(length = 100)
    private String email;
    private boolean enabled;
}
