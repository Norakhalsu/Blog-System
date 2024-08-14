package com.example.blogsystem.Service;

import com.example.blogsystem.Model.User;
import com.example.blogsystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userReposiroty;

    public List<User> getAllUsers() {
        return userReposiroty.findAll();
    }


    public void addUser(User user) {
        //LocalDate.now();
        userReposiroty.save(user);
    }

    public void UpdateUser(Integer id, User user) {
        User u = userReposiroty.findUserById(id);

        if (u == null) {
            throw new RuntimeException("User not found");
        }

        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setEmail(user.getEmail());
        userReposiroty.save(u);
    }

    public void deleteUser(Integer id) {
        User user = userReposiroty.findUserById(id);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        userReposiroty.delete(user);
    }

    // get all users by Registration Date between start and end
    public List<User> getUserByRegistrationsDate(LocalDate start, LocalDate end) {
        List<User> list = userReposiroty.findUserByRegistrationDateBetween(start, end);
        if (list == null) {
            throw new RuntimeException("User not found");
        }
        return list;
    }

    // get user by email
    public User getUserByEmail(String email) {
        if(userReposiroty.SearchUserByEmail(email) == null){
            throw new RuntimeException("User not found");
        }
        return userReposiroty.SearchUserByEmail(email);
    }




}



