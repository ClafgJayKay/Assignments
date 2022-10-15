package com.oct2022.oct2022.configuration;

import com.oct2022.oct2022.response.UserResponse;
import org.apache.catalina.User;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonException {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleException(CustomException e){
        UserResponse userResponse = new UserResponse();

        userResponse.setMessage(e.getMessage());
        return ResponseEntity.badRequest().body(userResponse);
    }
}
