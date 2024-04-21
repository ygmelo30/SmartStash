package com.inventory.yasser.smartStash.services;

import com.inventory.yasser.smartStash.models.User;
import com.inventory.yasser.smartStash.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public void saveUser (User user) {
        userRepo.save(user);
    }


    public void deleteUser(Long userId) {
        userRepo.deleteById(userId);
    }

    public void updateUser(User user) {
        userRepo.save(user);
    }
}
