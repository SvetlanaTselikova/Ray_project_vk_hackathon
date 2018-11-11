package com.vkteam.templates.repos;

import com.vkteam.templates.domain.pet.Pet;
import com.vkteam.templates.domain.task.Task;
import com.vkteam.templates.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITaskRepo extends JpaRepository<Task, Integer> {
    Task findById(int id);
    List<Task> findByUser(User user);
    List<Task> findByPet(Pet pet);
    List<Task> findAll();
}
