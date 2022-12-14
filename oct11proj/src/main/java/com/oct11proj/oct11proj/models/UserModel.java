package com.oct11proj.oct11proj.models;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="users")

public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String username;
    String password;

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
