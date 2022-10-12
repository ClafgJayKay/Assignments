package com.oct2022.oct2022.services;

import com.oct2022.oct2022.models.NewUserModel;
import com.oct2022.oct2022.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    public void addUser(){
        System.out.println("Adding new user");
        userRepo.save(new NewUserModel("Patty", 12345678));
    }

    public void retrieveAllUser(){
        userRepo.findAll().forEach(obj ->{
            System.out.println(obj.getId() + " " + obj.getName() + " - " + obj.getMobilenumber());
        });
    }
}
