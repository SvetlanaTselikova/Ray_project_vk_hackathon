package com.vkteam.templates.service;

import com.vkteam.templates.domain.user.User;
import com.vkteam.templates.exception.UserAlreadyExistException;
import com.vkteam.templates.exception.UserNotFoundException;
import com.vkteam.templates.repos.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepo userRepo;

    @Autowired
    private JWTService jwtService;

    public User validation(String token) {
        String[] encrData = jwtService.encrypt(token);
        User user = userRepo.findById((int)Integer.valueOf(encrData[1]));
        if(user != null) {
            if(String.valueOf(user.getPhoneNumber()).equals(encrData[0])) {
                return user;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public void updateUser(User user) {
        userRepo.save(user);
    }

    public void addUser(User user) throws UserAlreadyExistException {
        if(userRepo.findByPhoneNumber(user.getPhoneNumber()) == null) {
            userRepo.save(user);
        } else {
            throw new UserAlreadyExistException("User with that phone number is already exist");
        }
    }

    public User getUser(String phoneNumber) throws UserNotFoundException {
        User user = userRepo.findByPhoneNumber(phoneNumber);
        if(user != null) {
            return user;
        } else {
            throw new UserNotFoundException("User with that phone number does not exist");
        }
    }

    public void deleteUser(User user) {
        userRepo.delete(user);
    }
}
