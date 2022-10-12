package com.oct2022.oct2022.controllers;

import com.oct2022.oct2022.response.UserResponse;
import com.oct2022.oct2022.models.UserModel;
import com.oct2022.oct2022.models.NewUserModel;
import com.oct2022.oct2022.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("user")
    public ResponseEntity<?> getUser() {
        ArrayList<UserModel> sampleArrList = new ArrayList<>();
        UserResponse userResponse = new UserResponse();

        sampleArrList.add(new UserModel("Aaron", "pass1"));
        sampleArrList.add(new UserModel("Betty", "pass2"));
        sampleArrList.add(new UserModel("Chelsea", "pass3"));
        sampleArrList.add(new UserModel("Danny", "pass4"));
        sampleArrList.add(new UserModel("Eunice", "pass5"));

        return ResponseEntity.ok(sampleArrList);
    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<?> getUser(@PathVariable Integer user_id) {
        HashMap<Integer, UserModel> myHashMap = new HashMap<>();
        UserResponse userResponse = new UserResponse();

        for (int i = 1; i <= 10; i++) {
            myHashMap.put(i, new UserModel("user: " + i, "password: " + i));
        }

        if (myHashMap.containsKey(user_id)) {
            userResponse.setMessage("User exists");
            return ResponseEntity.ok(userResponse);
        } else {
            userResponse.setMessage("User does not exist");
            return ResponseEntity.badRequest().body(userResponse);
        }
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(){
        UserResponse userResponse = new UserResponse();
        userService.addUser();
        userResponse.setMessage("New user created");
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/retrieveUser")
    public ResponseEntity<?> userGet2(){
        UserResponse userResponse = new UserResponse();
        userService.retrieveAllUser();
        userResponse.setMessage("Retrieving user list");
        return ResponseEntity.ok(userResponse);
    }
}
