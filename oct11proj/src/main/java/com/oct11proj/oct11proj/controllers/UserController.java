package com.oct11proj.oct11proj.controllers;

import com.oct11proj.oct11proj.response.UserResponse;
import com.oct11proj.oct11proj.models.UserModel;

import jdk.jshell.spi.ExecutionControl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class UserController {

    @Autowired

    @GetMapping("/user")
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
        UserResponse generalResponse = new UserResponse();

        for (int i = 1; i <= 10; i++) {
            myHashMap.put(i, new UserModel("user: " + i, "password: " + i));
        }

        if (myHashMap.containsKey(user_id)) {
            generalResponse.setMessage("User exists");
            return ResponseEntity.ok(generalResponse);
        } else {
            generalResponse.setMessage("User does not exist");
            return ResponseEntity.badRequest().body(generalResponse);
        }
    }
}