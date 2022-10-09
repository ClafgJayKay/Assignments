package com.week5proj.week5proj.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class MathsResponse {
    String message;
    double addition;
    double subtract;
    double multiply;
    double divide;
}
