package com.vkteam.templates.repos;

import com.vkteam.templates.domain.pet.Pet;
import com.vkteam.templates.domain.shelter.Shelter;
import com.vkteam.templates.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPetRepo extends JpaRepository<Pet, Integer> {
    Pet findById(int id);
    Pet findByOwner(User owner);
    Iterable<Pet> findAllByShelter(Shelter shelter);
}
