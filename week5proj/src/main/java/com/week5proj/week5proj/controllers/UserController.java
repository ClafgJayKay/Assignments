package com.week5proj.week5proj.controllers;

import com.week5proj.week5proj.requests.MathsRequest;
import com.week5proj.week5proj.requests.UserRequest;
import com.week5proj.week5proj.models.UserModel;
import com.week5proj.week5proj.response.MathsResponse;
import com.week5proj.week5proj.response.UserResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.ArrayList;

@RestController
public class UserController {
    @PostMapping("userLogin")
    public ResponseEntity<?> login(@RequestBody UserRequest userRequest) {
        ArrayList<UserModel> userArrayList = new ArrayList<UserModel>();
        UserModel userModel1 = new UserModel("abc@gmail.com", "1pass");
        UserModel userModel2 = new UserModel("def@gmail.com", "2pass");
        UserModel userModel3 = new UserModel("ghi@gmail.com", "3pass");
        UserModel userModel4 = new UserModel("jkl@gmail.com", "4pass");

        userArrayList.add(userModel1);
        userArrayList.add(userModel2);
        userArrayList.add(userModel3);
        userArrayList.add(userModel4);

        UserResponse response = new UserResponse();
        boolean boolResponse = false;
        for (UserModel user : userArrayList) {
            if (userRequest.getEmail().equalsIgnoreCase(user.getEmail()) &&
                    userRequest.getPassword().equals(user.getPassword())) {
                boolResponse = true;
                break;
            } else boolResponse = false;
        }
        if (boolResponse) {
            response.setMessage("Login successful");
            return ResponseEntity.ok(response);
        } else {
            response.setMessage("Please enter a valid email or password.");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("user")
    public ArrayList<UserModel> getUsers(){
        UserResponse response = new UserResponse();
        ArrayList<UserModel> userModelArrayList = new ArrayList<UserModel>();
        UserModel userModel1 = new UserModel("abc@gmail.com", "user1","Tampines");
        UserModel userModel2 = new UserModel("def@gmail.com", "user2", "Bedok");
        UserModel userModel3 = new UserModel("ghi@gmail.com", "user3", "Changi");
        UserModel userModel4 = new UserModel("jkl@gmail.com", "user4", "Eunos");

        userModelArrayList.add(userModel1);
        userModelArrayList.add(userModel2);
        userModelArrayList.add(userModel3);
        userModelArrayList.add(userModel4);

        if(userModelArrayList.size()!=0){
            return userModelArrayList;
        }else{
            return null;
        }

    }

    @PostMapping("maths")
    public ResponseEntity<?> maths(@RequestBody MathsRequest mathRequest){
        MathsResponse response = new MathsResponse();
        if(mathRequest.getMathOperator().equalsIgnoreCase("add")){
            int result = mathRequest.getNum1()+ mathRequest.getNum2();
            response.setAddition(result);
            return ResponseEntity.ok(response);
        } else if (mathRequest.getMathOperator().equalsIgnoreCase("subtract")) {
            int result = mathRequest.getNum1()- mathRequest.getNum2();
            response.setSubtract(result);
            return ResponseEntity.ok(response);
        } else if (mathRequest.getMathOperator().equalsIgnoreCase("multiply")) {
            if(mathRequest.getNum1()!=0 && mathRequest.getNum2()!=0){
                int result = mathRequest.getNum1()*mathRequest.getNum2();
                response.setMultiply(result);
                return ResponseEntity.ok(response);
            }else{
                response.setMessage("Invalid multiplication");
                return ResponseEntity.badRequest().body(response);
            }
        } else if (mathRequest.getMathOperator().equalsIgnoreCase("divide")) {
            if(mathRequest.getNum1()!=0 && mathRequest.getNum2()!=0){
                double divide =  (double) mathRequest.getNum1()/mathRequest.getNum2();
                DecimalFormat df = new DecimalFormat("###.###");
                double result = Double.parseDouble(df.format(divide));
                response.setDivide(result);
                return ResponseEntity.ok(response);
            }else{
                response.setMessage("Invalid division");
                return ResponseEntity.badRequest().body(response);
            }
        } else {
            response.setMessage("Invalid entry");
            return ResponseEntity.badRequest().body(response);
        }
    }
}
