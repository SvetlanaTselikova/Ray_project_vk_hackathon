package com.vkteam.templates.controller;

import com.vkteam.templates.domain.pet.Pet;
import com.vkteam.templates.domain.user.User;
import com.vkteam.templates.service.PetService;
import com.vkteam.templates.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@ResponseBody
@RequestMapping("/pets")
public class PetController {
    @Autowired
    UserService userService;

    @Autowired
    PetService petService;

    @PostMapping("/add")
    public ResponseEntity<?> addPet(@RequestHeader("Authorization") String token, Pet pet, @RequestParam("img") MultipartFile img) throws IOException {
        if(userService.validation(token) != null) {
            if(pet != null) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .header("message", "Error init object Pet")
                        .body(null);
            }
            try {
                petService.addPet(pet, img);
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(null);
            } catch(IOException e) {
                e.printStackTrace();
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .header("message", "Could not save image")
                        .body(null);
            }
        } else {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .header("message", "Invalid token")
                    .body(null);
        }
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<?> getPetById(@RequestHeader("Authorization") String token, @PathVariable("id") Pet pet) {
        if(userService.validation(token) != null) {
            if(pet == null) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .header("message", "Pet not found")
                        .body(null);
            }
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(pet);
        } else {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .header("message", "Invalid token")
                    .body(null);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllPets(@RequestHeader("Authorization") String token) {
        if(userService.validation(token) != null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(petService.getAll());
        } else {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .header("message", "Invalid token")
                    .body(null);
        }
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUserPet(@RequestHeader("Authorization") String token) {
        User user = userService.validation(token);
        if(user != null) {
            if(user == null) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .header("message", "User with not found")
                        .body(null);
            }
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(petService.getUserPet(user));
        } else {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .header("message", "Invalid token")
                    .body(null);
        }
    }
}
