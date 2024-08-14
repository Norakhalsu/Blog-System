package com.example.blogsystem.Repository;

import com.example.blogsystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserById(Integer id);

    // 1- get all user Registration date between start and end date
    List<User> findUserByRegistrationDateBetween(LocalDate start, LocalDate end);


    @Query("select u from User u where u.email=?1") //get user by email
    User SearchUserByEmail(String email);
}
