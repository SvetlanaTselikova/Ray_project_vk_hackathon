package com.vkteam.templates.controller;

import com.vkteam.templates.domain.task.Task;
import com.vkteam.templates.domain.user.User;
import com.vkteam.templates.service.PetService;
import com.vkteam.templates.service.TaskService;
import com.vkteam.templates.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

@RestController
@RequestMapping("/tasks")
@ResponseBody
public class TaskController {
    @Autowired
    TaskService taskService;
    @Autowired
    UserService userService;
    @Autowired
    PetService petService;

    @PostMapping("/add")
    public ResponseEntity<?> addTask(@RequestHeader("Authorization") String token, Task task) {
        User user = userService.validation(token);
        if(user != null) {
            task.setBeginDate(Calendar.getInstance().getTime());
            taskService.addTask(task);

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

    @GetMapping("/profile/{id}")
    public ResponseEntity<?> getTaskById(@RequestHeader("Authorization") String token, @PathVariable("id") Task task) {
        if(userService.validation(token) != null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(task);
        } else {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .header("message", "Invalid token")
                    .body(null);
        }
    }

    @GetMapping("/ordered-all")
    public ResponseEntity<?> getOrderedAllTasks(@RequestHeader("Authorization") String token) {
        if(userService.validation(token) != null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(taskService.getAll());
        } else {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .header("message", "Invalid token")
                    .body(null);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllTasks(@RequestHeader("Authorization") String token) {
        if(userService.validation(token) != null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(TaskService.vlasovAlgo3000(taskService.getAll()));
        } else {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .header("message", "Invalid token")
                    .body(null);
        }
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUserTasks(@RequestHeader("Authorization") String token) {
        User user = userService.validation(token);
        if(user != null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(taskService.getUserTasks(user));
        } else {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .header("message", "Invalid token")
                    .body(null);
        }
    }
}
