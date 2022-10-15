package com.oct2022.oct2022.services;

import com.oct2022.oct2022.configuration.CustomException;
import com.oct2022.oct2022.models.UserModelWithToken;
import com.oct2022.oct2022.repository.UserRepository;
import com.oct2022.oct2022.request.UserRequest;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.core.env.Environment;

import java.util.*;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    @Autowired
    Environment environment;

    public List<UserModelWithToken> getAllUsers() {
        return userRepo.findAll();
    }

    public UserModelWithToken retrieveOneUser(Integer userid) {
        return userRepo.findById(userid).get();
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
        Optional<UserModelWithToken> user = userRepo.getUserByEmail(userRequest.getEmail());
        if (user.isPresent()) {
            throw new Exception("Email is taken");
        } else {
            UserModelWithToken userModelWithToken = new UserModelWithToken();
            userModelWithToken.setName(userRequest.getName());
            userModelWithToken.setPassword(userRequest.getPassword());
            userModelWithToken.setAddress(userRequest.getAddress());
            userModelWithToken.setEmail(userRequest.getEmail());
            userModelWithToken.setMobilenumber(userRequest.getMobilenumber());
            userRepo.save(userModelWithToken);
        }
    }

    public boolean deleteUser(Integer userid) throws Exception {
        try {
            Optional<UserModelWithToken> user = userRepo.findById(userid);
            if (user.isPresent()) {
                userRepo.deleteById(userid);
                return true;
            } else {
                throw new Exception("User not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public boolean updateUser(Integer userid, UserRequest userRequest) throws Exception {
        try {
            Optional<UserModelWithToken> user = userRepo.findById(userid);
            if (user.isPresent()) {
                UserModelWithToken userModelWithToken = userRepo.findById(userid).get();

                userModelWithToken.setAddress(userRequest.getAddress());
                userModelWithToken.setEmail(userRequest.getEmail());
                userModelWithToken.setPassword(userRequest.getPassword());
                userModelWithToken.setName(userRequest.getName());
                userModelWithToken.setMobilenumber(userRequest.getMobilenumber());
                userRepo.save(userModelWithToken);
                return true;
            } else {
                throw new Exception("No such user in database");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public UserModelWithToken login(UserRequest userRequest) throws Exception {
        try {
            Optional<UserModelWithToken> user = userRepo.getUserByEmail(userRequest.getEmail());

            if (userRepo.getUserByEmail(userRequest.getEmail()).stream().count() < 1) {
                throw new Exception("Error in user email");
            }

            if (userRequest.getEmail().equals(user.get().getEmail()) && userRequest.getPassword().equals(user.get().getPassword())) {

                String token = generateToken(user.get());
                user.get().setToken(token);
                userRepo.setToken(token, user.get().getUserid());

                return user.get();
            } else {
                throw new Exception("Error in user details");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void logout(Integer userid) throws CustomException {
        Optional<UserModelWithToken> user = userRepo.findById(userid);
        if (user.isPresent()) {
            userRepo.setToken("", user.get().getUserid());
        } else {
            throw new CustomException("Error in logout");
        }
    }

    public String generateToken(UserModelWithToken user) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 10);

        String token = Jwts.builder()
                .claim("email", user.getEmail())
                .claim("name", user.getName())
                .setSubject(user.getName())
                .setId("" + user.getUserid())
                .setIssuedAt(new Date())
                .setExpiration(calendar.getTime())
                .signWith(SignatureAlgorithm.HS512, environment.getProperty("jwt_token"))
                .compact();

        return token;
    }

    public boolean validateToken(Integer userid, String token) throws CustomException {
            Optional<UserModelWithToken> user = userRepo.findById(userid);

            if (user.isPresent()) {
                if (token.equals(user.get().getToken())) {
                    System.out.println("token retrieved");
                    return true;
                } else {
                    throw new CustomException("token error");
                }
            } else {
                throw new CustomException("Error in token validation");
            }
    }

    public boolean isTokenExpired(String token) throws CustomException{
        System.out.println("Token is still active");

        try{
            Jwts.parser().setSigningKey(environment.getProperty("jwt_token")).parseClaimsJws(token);
            return true;
        }catch(ExpiredJwtException e){
            throw new CustomException("Token has expired");
        }
        catch(Exception e){
            throw new CustomException("error with token");
        }
    }

    public void setUserProfilePic(Integer userid, String profilePic) throws CustomException{
        try{
            userRepo.setProfilePic(userid, profilePic);
        }catch (Exception e){
            throw new CustomException("unable to set profile pic");
        }
    }

    public String getUserProfilePic(Integer userid) throws CustomException{
        try{
            return userRepo.getProfilePic(userid);
        }catch (Exception e){
            throw new CustomException("unable to get profile pic");
        }
    }
}
