package com.vkteam.templates.controller;

import com.vkteam.templates.domain.user.User;
import com.vkteam.templates.exception.UserAlreadyExistException;
import com.vkteam.templates.exception.UserNotFoundException;
import com.vkteam.templates.service.JWTService;
import com.vkteam.templates.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Map;

@RestController
@RequestMapping("/users")
@ResponseBody
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private JWTService jwtService;

    @PostMapping("/register")
    public ResponseEntity<?> reg(User user) {
        if(user == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .header("message", "Could not init object User")
                    .body(null);
        }

        if(user.getPassword().contains("#")) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .header("message", "Password have unacceptable characters")
                    .body(null);
        }

        user.setRate(0);
        user.setRole("USER");
        user.setAchievements(new HashSet<>());
        try {
            userService.addUser(user);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(null);
        } catch(UserAlreadyExistException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .header("message", e.getMessage())
                    .body(null);
        }
    }

    @PostMapping("/auth")
    public ResponseEntity<?> auth(@RequestBody Map<String, String> data) {
        User user;
        if(data.containsKey("phoneNumber") && data.containsKey("password")) {
            try {
                user = userService.getUser(data.get("phoneNumber"));

                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(jwtService.getToken(user.getPhoneNumber() + "#" + user.getId()));
            } catch(UserNotFoundException e) {
                e.printStackTrace();
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .header("message", e.getMessage())
                        .body(null);
            }
        } else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .header("message", "Phone number or password is missing")
                    .body(null);
        }
    }
}
