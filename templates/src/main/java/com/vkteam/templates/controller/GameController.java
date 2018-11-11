package com.vkteam.templates.controller;

import com.vkteam.templates.domain.other.Action;
import com.vkteam.templates.domain.pet.Pet;
import com.vkteam.templates.domain.user.User;
import com.vkteam.templates.repos.IActionRepo;
import com.vkteam.templates.service.JWTService;
import com.vkteam.templates.service.PetService;
import com.vkteam.templates.service.TaskService;
import com.vkteam.templates.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/game")
@RestController
@ResponseBody
public class GameController {
    @Autowired
    UserService userService;

    @Autowired
    JWTService jwtService;

    @Autowired
    PetService petService;

    @Autowired
    IActionRepo actionRepo;

    @Autowired
    TaskService taskService;

    @PostMapping("/follow")
    public ResponseEntity<?> follow(@RequestHeader("Authorization") String token, int petId) {
        User player = userService.validation(token);
        if(player != null) {

            Pet pet = petService.getPetById(petId);
            pet.setOwner(player);
            taskService.getPetTask(pet).forEach(task -> {
                task.setUser(player);
                taskService.updateTask(task);
            });
            petService.updatePet(pet);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(null);
        } else {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .header("message", "Invalid token")
                    .body(null);
        }
    }

    @PostMapping("/feed")
    public ResponseEntity<?> feed(@RequestHeader("Authorization") String token, int count) {
        User player = userService.validation(token);
        if(player != null) {

            Pet pet = petService.getUserPet(player);

            if(pet != null) {

                if(30 * count > player.getBalance()) {
                    return ResponseEntity
                            .status(HttpStatus.FORBIDDEN)
                            .header("message", "Insufficient funds")
                            .body(null);
                }

                pet.setFoodLvl(pet.getFoodLvl() + 1 * count);
                player.setBalance(player.getBalance() - 30 * count);
                player.setRate(player.getRate() + 2 * count);

                petService.updatePet(pet);
                userService.updateUser(player);

                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(pet);
            } else {
                return ResponseEntity
                        .status(HttpStatus.FORBIDDEN)
                        .header("message", "User does not follow this pet")
                        .body(null);
            }
        } else {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .header("message", "Invalid token")
                    .body(null);
        }
    }

    @PostMapping("/health")
    public ResponseEntity<?> health(@RequestHeader("Authorization") String token, int actionId) {
        User player = userService.validation(token);
        if(player != null) {

            Pet pet = petService.getUserPet(player);
            Action action = actionRepo.findById(actionId);

            if(pet != null && action.getType().equals("health")) {

                if(action.getCost() > player.getBalance()) {
                    return ResponseEntity
                            .status(HttpStatus.FORBIDDEN)
                            .header("message", "Insufficient funds")
                            .body(null);
                }

                pet.setHealthLvl(pet.getHealthLvl() + action.getTypePoints());
                player.setBalance(player.getBalance() - action.getCost());
                player.setRate(player.getRate() + action.getXpPoints());

                petService.updatePet(pet);
                userService.updateUser(player);

                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(pet);
            } else {
                return ResponseEntity
                        .status(HttpStatus.FORBIDDEN)
                        .header("message", "User does not follow this pet")
                        .body(null);
            }
        } else {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .header("message", "Invalid token")
                    .body(null);
        }
    }

    @PostMapping("/walk")
    public ResponseEntity<?> walk(@RequestHeader("Authorization") String token) {
        if(userService.validation(token) != null) {
            /* do something*/
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(null);
        } else {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .header("message", "Invalid token")
                    .body(null);
        }
    }

    @PostMapping("/filler")
    public ResponseEntity<?> filler(@RequestHeader("Authorization") String token, int count) {
        User player = userService.validation(token);
        if(player != null) {

            Pet pet = petService.getUserPet(player);

            if(pet != null) {

                if(50 * count > player.getBalance()) {
                    return ResponseEntity
                            .status(HttpStatus.FORBIDDEN)
                            .header("message", "Insufficient funds")
                            .body(null);
                }

                pet.setFillerLvl(pet.getFillerLvl() + 1 * count);
                player.setBalance(player.getBalance() - 50 * count);
                player.setRate(player.getRate() + 1 * count);

                petService.updatePet(pet);
                userService.updateUser(player);

                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(pet);
            } else {
                return ResponseEntity
                        .status(HttpStatus.FORBIDDEN)
                        .header("message", "User does not follow this pet")
                        .body(null);
            }
        } else {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .header("message", "Invalid token")
                    .body(null);
        }
    }

    @PostMapping("/toys")
    public ResponseEntity<?> toys(@RequestHeader("Authorization") String token, int actionId) {
        User player = userService.validation(token);
        if(player != null) {

            Pet pet = petService.getUserPet(player);
            Action action = actionRepo.findById(actionId);

            if(pet != null && action.getType().equals("toy")) {

                if(action.getCost() > player.getBalance()) {
                    return ResponseEntity
                            .status(HttpStatus.FORBIDDEN)
                            .header("message", "Insufficient funds")
                            .body(null);
                }

                pet.setFunLvl(pet.getFunLvl() + action.getTypePoints());
                player.setBalance(player.getBalance() - action.getCost());
                player.setRate(player.getRate() + action.getXpPoints());

                petService.updatePet(pet);
                userService.updateUser(player);

                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(pet);
            } else {
                return ResponseEntity
                        .status(HttpStatus.FORBIDDEN)
                        .header("message", "User does not follow this pet")
                        .body(null);
            }
        } else {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .header("message", "Invalid token")
                    .body(null);
        }
    }
}
