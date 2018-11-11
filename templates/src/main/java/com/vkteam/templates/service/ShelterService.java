package com.vkteam.templates.service;

import com.vkteam.templates.domain.shelter.Shelter;
import com.vkteam.templates.exception.ShelterIsAlreadyExistException;
import com.vkteam.templates.repos.IShelterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class ShelterService {
    @Autowired
    private IShelterRepo shelterRepo;

    @Value("${upload.path}")
    private String uploadPath;

    public void addShelter(Shelter shelter, MultipartFile img) throws IOException, ShelterIsAlreadyExistException {
        if(getShelterByTitle(shelter.getTitle()) != null) {
            throw new ShelterIsAlreadyExistException("Shelter with that title is already exist");
        }

        if(img != null && !img.getOriginalFilename().isEmpty()) {
            File dir = new File(uploadPath);
            if(!dir.exists()) {
                dir.mkdir();
            }
            String uuid = UUID.randomUUID().toString();
            String resultFilename = uuid + "." + img.getOriginalFilename();
            img.transferTo(new File(uploadPath + "/" + resultFilename));

            shelter.setImg(resultFilename);
        }

        shelterRepo.save(shelter);
    }

    public Shelter getShelterByTitle(String title) {
        return shelterRepo.findByTitle(title);
    }

    public Shelter getShelterById(int id) {
        return shelterRepo.findById(id);
    }

    public Iterable<Shelter> getAll() {
        return shelterRepo.findAll();
    }
}
