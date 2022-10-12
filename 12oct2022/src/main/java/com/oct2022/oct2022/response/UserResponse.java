package com.oct2022.oct2022.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class UserResponse {
    String  name, address, email, mobileNum, password, message;
}
