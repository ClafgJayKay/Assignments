package com.oct11proj.oct11proj.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class UserModel {
    String username;
    String password;

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
