package com.nubiform.springdatajpa.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@ToString
@Entity
@Table(name = "owners")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String telephone;

    @Builder
    public Owner(String firstName, String lastName, String address, String city, String telephone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }
}
