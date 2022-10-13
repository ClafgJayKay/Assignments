package com.oct2022.oct2022.controllers;

import com.oct2022.oct2022.repository.UserRepository;
import com.oct2022.oct2022.response.UserResponse;
import com.oct2022.oct2022.models.NewUserModel;
import com.oct2022.oct2022.services.UserService;
import com.oct2022.oct2022.request.UserRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user")
    public ResponseEntity<?> getAllUsers(){
        UserResponse userResponse = new UserResponse();
        List<NewUserModel> myList = userService.getAllUsers();

        userResponse.setMessage("Getting all users");
        return ResponseEntity.ok(myList);
    }
    @GetMapping("/user/{userid}")
    public ResponseEntity<?> getUser(@PathVariable Integer userid) throws Exception {
        try {
            NewUserModel user = userService.retrieveUser(userid);
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
    @PostMapping("/deleteUser/{userid}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer userid){
        UserResponse userResponse = new UserResponse();
        try{
            userService.deleteUser(userid);
            userResponse.setMessage("User deleted");
            return ResponseEntity.ok(userResponse);
        }catch (Exception e){
            userResponse.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(userResponse);
        }
    }

    @PostMapping("/updateUser/{userid}")
    public ResponseEntity<?> updateUser(@PathVariable Integer userid, @RequestBody UserRequest userRequest){
        UserResponse userResponse = new UserResponse();
        try{
            userService.updateUser(userid, userRequest);
            userResponse.setMessage("User has been updated");
            return ResponseEntity.ok(userResponse);
        }catch (Exception e){
            userResponse.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(userResponse);
        }
    }
}
