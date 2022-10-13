package com.oct2022.oct2022.models;

import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="users2")

public class UserModelWithToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String email;
    String address;
    String mobilenumber;
    @JsonIgnore
    String token;
    String password;


    public UserModelWithToken(String name, String mobilenumber, String email, String address, String password) {
        this.name = name;
        this.mobilenumber = mobilenumber;
        this.email = email;
        this.address = address;
        this.password = password;
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
