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
    Integer userid;
    String name;
    String email;
    String address;
    String mobilenumber;
    @JsonIgnore
    String password;
    String token;
    String profile_pic;
}
