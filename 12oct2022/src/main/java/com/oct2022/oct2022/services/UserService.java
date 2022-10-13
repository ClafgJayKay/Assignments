package com.oct2022.oct2022.services;

import com.oct2022.oct2022.models.UserModelWithToken;
import com.oct2022.oct2022.repository.UserRepository;
import com.oct2022.oct2022.request.UserRequest;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    public List<UserModelWithToken> getAllUsers(){
        return userRepo.findAll();
    }
    public UserModelWithToken retrieveUser(Integer id) throws Exception {
        Optional<UserModelWithToken> user = userRepo.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new Exception("No such user");
        }
    }

    public Optional<UserModelWithToken> loginValidation(UserRequest userRequest) throws Exception {
        Optional<UserModelWithToken> user = userRepo.getUserByEmail(userRequest.getEmail());
        if (user.isPresent()) {
            return user;
        } else {
            throw new Exception("Login unsuccessful");
        }
    }

    public void createUser(UserRequest userRequest) throws Exception {
        Optional<UserModelWithToken> existingUser = userRepo.getUserByEmail(userRequest.getEmail());
        if (existingUser.isPresent()) {
            throw new Exception("Email is taken");
        } else {
            UserModelWithToken newUser = new UserModelWithToken();
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
            Optional<UserModelWithToken> user = userRepo.findById(userid);
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
            Optional<UserModelWithToken> theUser = userRepo.findById(userid);
            if (theUser.isPresent()) {
                UserModelWithToken user = userRepo.findById(userid).get();

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
    public UserModelWithToken loginwithToken(UserRequest userRequest)throws Exception{
        try{
            Optional<UserModelWithToken> userModelWithToken = userRepo.getUserByEmail(userRequest.getEmail());

            if(userRepo.getUserByEmail(userRequest.getEmail()).stream().count() < 1){
                throw new Exception("Error in user details");
            }

            if(userRequest.getEmail().equals(userModelWithToken.get().getEmail()) && userRequest.getPassword().equals(userModelWithToken.get().getPassword())){

                String token = generateToken(userModelWithToken.get());
                userModelWithToken.get().setToken(token);
                userRepo.setToken(token, userModelWithToken.get().getId());

                return userModelWithToken.get();
            }else{
                throw new Exception("Error in user details");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    public void logout(Integer userid) throws Exception{
        try{
            Optional <UserModelWithToken> userModelWithToken = userRepo.findById(userid);
            if(userModelWithToken.isPresent()){
                userRepo.setToken("", userModelWithToken.get().getId());
            }else{
                throw new Exception("Error in logout");
            }

        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    public String generateToken(UserModelWithToken userModelWithToken){
        String token = Base64.getEncoder().encode(userModelWithToken.getEmail().getBytes()).toString() + Base64.getEncoder().encode(userModelWithToken.getName().getBytes()).toString();
        return token;
    }

    public boolean validateToken(Integer user_id, String token) throws Exception{
        try{
            Optional <UserModelWithToken> userModelWithToken = userRepo.findById(user_id);

            if(userModelWithToken.isPresent()){
                if(token.equals(userModelWithToken.get().getToken())){
                    System.out.println("token retrieved");
                    return true;
                }else{
                    throw new Exception("token error");
                }
            }else{
                throw new Exception("Error in token validation");
            }
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
