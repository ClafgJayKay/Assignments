package com.oct2022.oct2022.controllers;

import com.oct2022.oct2022.repository.UserRepository;
import com.oct2022.oct2022.response.UserResponse;
import com.oct2022.oct2022.models.NewUserModel;
import com.oct2022.oct2022.services.UserService;
import com.oct2022.oct2022.request.UserRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepo;

    @GetMapping("user")
    public ResponseEntity<?> getUser(@PathVariable Integer id) throws Exception {
        try {
            NewUserModel user = userService.retrieveUser(id);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            UserResponse userResponse = new UserResponse();
            userResponse.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(userResponse);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginValid(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = new UserResponse();
        try {
            Optional<NewUserModel> user = userService.loginValidation(userRequest);

            return ResponseEntity.ok(user);
        } catch (Exception e) {
            userResponse.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(userResponse);
        }
    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<?> getUser(@PathVariable Integer id) throws Exception {
        try {
            NewUserModel user = userService.retrieveUser(id);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            UserResponse userResponse = new UserResponse();
            userResponse.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(userResponse);
        }
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = new UserResponse();
        try {
            userService.createUser(userRequest);
            userResponse.setMessage("User created");
            return ResponseEntity.ok(userResponse);
        } catch (Exception e) {
            userResponse.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(userResponse);
        }
    }
    @PostMapping("/delete/{userid}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        UserResponse userResponse = new UserResponse();
        try{
            userService.deleteUser(id);
            userResponse.setMessage("User deleted");
            return ResponseEntity.ok(userResponse);
        }catch (Exception e){
            userResponse.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(userResponse);
        }
    }
}
