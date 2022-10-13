package com.oct2022.oct2022.repository;

import com.oct2022.oct2022.models.NewUserModel;
import com.oct2022.oct2022.models.UserModelWithToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModelWithToken, Integer> {
//    @Query("SELECT user FROM NewUserModel user WHERE email=?1 and password=?2")
//    Optional<NewUserModel> getUserByEmailAndPassword(String email, String password);
//
//    @Query("SELECT user FROM NewUserModel user WHERE email = ?1")
//    Optional<NewUserModel> getUserByEmail(String email);
    @Query("select userModelWithToken from UserModelWithToken userModelWithToken where email = ?1")
    Optional<UserModelWithToken> getUserByEmail(String email);
    @Modifying
    @Transactional
    @Query("update UserModelWithToken set token = ?1 where id = ?2")
    void setToken(String token, Integer id);
}
