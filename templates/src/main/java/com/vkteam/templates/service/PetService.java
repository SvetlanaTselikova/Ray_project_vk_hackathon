package com.vkteam.templates.service;

import com.vkteam.templates.domain.pet.Pet;
import com.vkteam.templates.domain.shelter.Shelter;
import com.vkteam.templates.domain.user.User;
import com.vkteam.templates.repos.IPetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class PetService {
    @Autowired
    IPetRepo petRepo;

    @Value("${upload.path}")
    private String uploadPath;

    public void updatePet(Pet pet) {
        petRepo.save(pet);
    }

    public void addPet(Pet pet, MultipartFile img) throws IOException {
        if(img != null && !img.getOriginalFilename().isEmpty()) {
            File dir = new File(uploadPath);
            if(!dir.exists()) {
                dir.mkdir();
            }
            String uuid = UUID.randomUUID().toString();
            String resultFilename = uuid + "." + img.getOriginalFilename();
            img.transferTo(new File(uploadPath + "/" + resultFilename));

            pet.setImg(resultFilename);
        }
        pet.setOwner(null);

        petRepo.save(pet);
    }

    public Iterable<Pet> getAll() {
        return petRepo.findAll();
    }

    public Pet getUserPet(User owner) {
        return petRepo.findByOwner(owner);
    }

    public Iterable<Pet> getPetsByShelter(Shelter shelter) {
        return petRepo.findAllByShelter(shelter);
    }

    public Pet getPetById(int id) {
        return petRepo.findById(id);
    }
}
