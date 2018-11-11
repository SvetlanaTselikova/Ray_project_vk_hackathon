package com.vkteam.templates.repos;

import com.vkteam.templates.domain.shelter.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShelterRepo extends JpaRepository<Shelter, Integer> {
    Shelter findById(int id);
    Shelter findByTitle(String title);
}
