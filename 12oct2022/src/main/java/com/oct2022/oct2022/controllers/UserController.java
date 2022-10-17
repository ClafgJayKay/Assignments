package com.oct2022.oct2022.controllers;

import com.oct2022.oct2022.configuration.CustomException;
import com.oct2022.oct2022.models.UserModelWithToken;
import com.oct2022.oct2022.repository.UserRepository;
import com.oct2022.oct2022.response.UserResponse;
import com.oct2022.oct2022.models.NewUserModel;
import com.oct2022.oct2022.services.UserService;
import com.oct2022.oct2022.request.UserRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "false")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    String imagePath = "C:\\Users\\phang\\Documents\\GitHub\\Assignments\\12oct2022\\src\\main\\java\\com\\oct2022\\oct2022\\images\\";

    @GetMapping("/user")
    public ResponseEntity<?> getAllUsers(){
        UserResponse userResponse = new UserResponse();
        List<UserModelWithToken> myList = userService.getAllUsers();
        userResponse.setMessage("Getting all users");
        return ResponseEntity.ok(myList);
    }
    @GetMapping("/user/{userid}")
    public ResponseEntity<?> retrieveOneUser(@PathVariable Integer userid) throws Exception {
        try {
            UserModelWithToken user = userService.retrieveOneUser(userid);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            UserResponse userResponse = new UserResponse();
            userResponse.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(userResponse);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRequest userRequest) {
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
            userResponse.setMessage("User info updated");
            return ResponseEntity.ok(userResponse);
        }catch (Exception e){
            userResponse.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(userResponse);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequest userRequest){
        UserResponse userResponse = new UserResponse();
        try{
            UserModelWithToken user = userService.login(userRequest);
            userResponse.setMessage("Logged in successfully");
            return ResponseEntity.ok(user);
        }catch (Exception e){
            userResponse.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(userResponse);
        }
    }
    @PostMapping("/logout/{userid}")
    public ResponseEntity<?> logout(@PathVariable Integer userid){
        UserResponse userResponse = new UserResponse();
        try{
            userService.logout(userid);
            userResponse.setMessage("User logged out successfully");
            return ResponseEntity.ok(userResponse);
        }catch(Exception e){
            userResponse.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(userResponse);
        }
    }

    @PostMapping("/uploadImage")
    public ResponseEntity<?> uploadImage(@RequestParam Integer userid, @RequestParam MultipartFile multipartFile) throws Exception {
        UserResponse userResponse = new UserResponse();

        System.out.println(userid + " " + multipartFile.getOriginalFilename());

        FileOutputStream fileOutputStream = new FileOutputStream(imagePath + multipartFile.getOriginalFilename());
        fileOutputStream.write(multipartFile.getBytes());
        fileOutputStream.close();

        userService.setUserProfilePic(userid, multipartFile.getOriginalFilename());

        userResponse.setMessage("image uploaded successfully");
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping(value = "/getImage/{userid}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public byte[] getImage(@PathVariable Integer userid) throws Exception{

        String fileName = userService.getUserProfilePic(userid);

        System.out.println(imagePath + fileName);

        FileInputStream fileInputStream = new FileInputStream(imagePath + fileName);
//        fileInputStream.close();

        return IOUtils.toByteArray(fileInputStream);
    }
}
