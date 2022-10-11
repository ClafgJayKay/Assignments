package com.oct11proj.oct11proj.controllers;

import com.oct11proj.oct11proj.response.UserResponse;
import com.oct11proj.oct11proj.models.UserModel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@RestController
public class LoginController {
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserModel userModel){
        ArrayList<UserModel> myArrList = new ArrayList<>();
        UserResponse generalResponse = new UserResponse();

        myArrList.add(new UserModel("Aaron", "one"));
        myArrList.add(new UserModel("Betty", "two"));
        myArrList.add(new UserModel("Charlie", "three"));
        myArrList.add(new UserModel("Danny", "four"));

        for (UserModel eachUser: myArrList ) {
            if(eachUser.getUsername().equals(userModel.getUsername())){
                if(eachUser.getPassword().equals(userModel.getPassword())){
                    generalResponse.setMessage("Login Successful");
                    return ResponseEntity.ok(generalResponse);
                }
            }
        }
        generalResponse.setMessage("Please enter valid username and password");
        return ResponseEntity.badRequest().body(generalResponse);
    }

    @PostMapping("/loginV2")
    public ResponseEntity<?> loginV2(@RequestParam String username, @RequestParam String password){
        ArrayList<UserModel> myArrList = new ArrayList<>();
        UserResponse generalResponse = new UserResponse();

        myArrList.add(new UserModel("Aaron", "one"));
        myArrList.add(new UserModel("Betty", "two"));
        myArrList.add(new UserModel("Charlie", "three"));
        myArrList.add(new UserModel("Danny", "four"));

        System.out.println("username is: " + username + " password is: " + password);

        for (UserModel eachUser: myArrList ) {
            if(eachUser.getUsername().equals(username)){
                if(eachUser.getPassword().equals(password)){
                    generalResponse.setMessage("Login Successful");
                    return ResponseEntity.ok(generalResponse);
                }
            }
        }
        generalResponse.setMessage("Please enter valid username and password");
        return ResponseEntity.badRequest().body(generalResponse);
    }
}
