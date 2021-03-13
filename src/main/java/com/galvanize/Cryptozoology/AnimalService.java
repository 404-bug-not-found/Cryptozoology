package com.galvanize.Cryptozoology;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;

    @Autowired
    AnimalService(AnimalRepository animalRepository){
        this.animalRepository=animalRepository;
    }

    public void create(AnimalDTO animalDTO) {
        animalRepository.save(
                new AnimalEntity(
                        animalDTO.getName(),
                        animalDTO.getType(),
                        animalDTO.getMood()
                )
        );
    }
}
