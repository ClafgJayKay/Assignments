package com.oct2022.oct2022.services;

import com.oct2022.oct2022.models.NewUserModel;
import com.oct2022.oct2022.repository.UserRepository;
import com.oct2022.oct2022.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;


    public List<NewUserModel> getAllUsers(){
        return userRepo.findAll();
    }
    public NewUserModel retrieveUser(Integer id) throws Exception {
        Optional<NewUserModel> user = userRepo.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new Exception("No such user");
        }
    }

    public Optional<NewUserModel> loginValidation(UserRequest userRequest) throws Exception {
        Optional<NewUserModel> user = userRepo.getUserByEmailAndPassword(userRequest.getEmail(), userRequest.getPassword());
        if (user.isPresent()) {
            return user;
        } else {
            throw new Exception("Login unsuccessful");
        }
    }

    public void createUser(UserRequest userRequest) throws Exception {
        Optional<NewUserModel> existingUser = userRepo.getUserByEmail(userRequest.getEmail());
        if (existingUser.isPresent()) {
            throw new Exception("Email is taken");
        } else {
            NewUserModel newUser = new NewUserModel();
            newUser.setName(userRequest.getName());
            newUser.setPassword(userRequest.getPassword());
            newUser.setAddress(userRequest.getAddress());
            newUser.setEmail(userRequest.getEmail());
            newUser.setMobilenumber(userRequest.getMobilenumber());
            userRepo.save(newUser);
        }
    }

    public boolean deleteUser(Integer userid) throws Exception {
        try{
            Optional<NewUserModel> user = userRepo.findById(userid);
            if (user.isPresent()) {
                userRepo.deleteById(userid);
                return true;
            } else {
                throw new Exception("User not Found");
            }
        }
        catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public boolean updateUser(Integer userid, UserRequest userRequest) throws Exception {
        try {
            Optional<NewUserModel> theUser = userRepo.findById(userid);
            if (theUser.isPresent()) {
                NewUserModel user = userRepo.findById(userid).get();

                user.setAddress(userRequest.getAddress());
                user.setEmail(userRequest.getEmail());
                user.setPassword(userRequest.getPassword());
                user.setName(userRequest.getName());
                user.setMobilenumber(userRequest.getMobilenumber());
                userRepo.save(user);
                return true;
            } else {
                throw new Exception("User does not exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }
}
