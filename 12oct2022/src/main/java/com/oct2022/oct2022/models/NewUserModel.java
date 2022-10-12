package com.oct2022.oct2022.models;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="users")

public class NewUserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "email")
    String email;
    @Column(name = "password")
    String password;
    @Column(name = "address")
    String address;
    @Column(name = "mobilenumber")
    String mobilenumber;

    public NewUserModel(Integer id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }
    public NewUserModel(String email, String password) {
        this.email = email;
        this.password = password;
    }
}