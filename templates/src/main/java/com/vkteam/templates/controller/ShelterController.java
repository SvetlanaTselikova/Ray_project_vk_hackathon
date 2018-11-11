package com.vkteam.templates.controller;

import com.vkteam.templates.domain.shelter.Shelter;
import com.vkteam.templates.exception.ShelterIsAlreadyExistException;
import com.vkteam.templates.service.ShelterService;
import com.vkteam.templates.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@ResponseBody
@RequestMapping("/shelter")
public class ShelterController {
    @Autowired
    UserService userService;

    @Autowired
    ShelterService shelterService;

    @PostMapping("/add")
    public ResponseEntity<?> addShelter(@RequestHeader("Authorization") String token, Shelter shelter, MultipartFile img) throws IOException {
        if(userService.validation(token) != null) {
            if(shelter == null) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .header("message", "Could not init object Shelter")
                        .body(null);
            }
            try {
                shelterService.addShelter(shelter, img);
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(null);
            } catch(ShelterIsAlreadyExistException e) {
                e.printStackTrace();
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .header("message", e.getMessage())
                        .body(null);
            }
        } else {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .header("message", "Invalid token")
                    .body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getShelterById(@RequestHeader("Authorization") String token, @PathVariable("id") Shelter shelter) {
        if(userService.validation(token) != null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(shelter);
        } else {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .header("message", "Invalid token")
                    .body(null);
        }
    }
}
