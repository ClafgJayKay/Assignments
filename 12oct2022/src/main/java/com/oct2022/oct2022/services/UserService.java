package com.oct2022.oct2022.services;

import com.oct2022.oct2022.models.NewUserModel;
import com.oct2022.oct2022.repository.UserRepository;
import com.oct2022.oct2022.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    public void retrieveUser(Integer id) throws Exception {
        Optional<NewUserModel> user = userRepo.findById(id);
        if(user.isPresent()){
            return user.get();
        }else{
            throw new Exception("No such user");
        }
    }

    public Optional<NewUserModel> loginValidation(UserRequest userRequest) throws Exception {
        Optional<NewUserModel> user = userRepo.getUserByEmailAndPassword(userRequest.getEmail(), userRequest.getPassword());
        if(user.isPresent()){
            return user;
        }else {
            throw new Exception("Login unsuccessful");
        }
    }

    public void createUser(UserRequest userRequest) throws Exception{
        Optional<NewUserModel> existingUser = userRepo.getUserByEmail(userRequest.getEmail());
        if(existingUser.isPresent()){
            throw new Exception("Email is taken");
        }else{
            NewUserModel newUser = new NewUserModel();
            newUser.setName(userRequest.getName());
            newUser.setPassword(userRequest.getPassword());
            newUser.setAddress(userRequest.getAddress());
            newUser.setEmail(userRequest.getEmail());
            newUser.setMobilenumber(userRequest.getMobileNum());
            userRepo.save(newUser);
        }
    }
    public boolean deleteUser(Integer id) throws Exception {
        Optional<NewUserModel> user = userRepo.findById(id);
        if(user.isPresent()){
            userRepo.deleteById(id);
            return true;
        }else {
            throw new Exception("User not Found");
        }
    }

}
