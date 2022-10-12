package com.oct2022.oct2022.models;

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
