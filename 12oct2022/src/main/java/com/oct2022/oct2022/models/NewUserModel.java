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
    Integer id;
    @Column(name="name")
    String name;
    @Column(name="email")
    String email;
    @Column(name="password")
    String password;
    @Column(name="address")
    String address;
    @Column(name="mobilenumber")
    String mobilenumber;

    public NewUserModel(Integer id, String name, String address, String email, String password, String mobilenumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.mobilenumber = mobilenumber;
    }
}