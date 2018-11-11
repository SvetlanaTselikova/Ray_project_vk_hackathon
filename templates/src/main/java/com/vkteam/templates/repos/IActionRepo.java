package com.vkteam.templates.repos;

import com.vkteam.templates.domain.other.Action;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IActionRepo extends JpaRepository<Action, Integer> {
    Action findById(int id);
    Iterable<Action> findByType(String type);
}
