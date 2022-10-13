package com.oct2022.oct2022.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class UserRequest {
    String name;
    String address;
    String email;
    String password;
    String mobilenumber;
}
