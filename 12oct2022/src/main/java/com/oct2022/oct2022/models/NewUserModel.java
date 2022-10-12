package com.oct2022.oct2022.models;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="newusers")

public class NewUserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String name;
    Integer mobilenumber;

    public NewUserModel(String name, Integer mobilenumber) {
        this.name = name;
        this.mobilenumber = mobilenumber;
    }
}