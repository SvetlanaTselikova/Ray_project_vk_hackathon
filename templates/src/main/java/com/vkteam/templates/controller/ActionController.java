package com.vkteam.templates.controller;

import com.vkteam.templates.repos.IActionRepo;
import com.vkteam.templates.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("/actions")
public class ActionController {
    @Autowired
    UserService userService;

    @Autowired
    IActionRepo actionRepo;

    @GetMapping("/health")
    public ResponseEntity<?> getHealtActions(@RequestHeader("Authorization") String token) {
        if(userService.validation(token) != null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(actionRepo.findByType("health"));
        } else {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .header("message", "Invalid token")
                    .body(null);
        }
    }

    @GetMapping("/toys")
    public ResponseEntity<?> getToysActions(@RequestHeader("Authorization") String token) {
        if(userService.validation(token) != null) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(actionRepo.findByType("toy"));
        } else {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .header("message", "Invalid token")
                    .body(null);
        }
    }
}

