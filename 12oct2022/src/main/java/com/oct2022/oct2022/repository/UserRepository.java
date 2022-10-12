package com.oct2022.oct2022.repository;

import com.oct2022.oct2022.models.NewUserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<NewUserModel, Integer> {
    @Query("SELECT user from NewUserModel user where email=?1 and password=?2")
    Optional<NewUserModel> getUserByEmailAndPassword(String email, String password);

    @Query("SELECT user from NewUserModel user where email = ?1")
    Optional<NewUserModel> getUserByEmail(String email);
}
