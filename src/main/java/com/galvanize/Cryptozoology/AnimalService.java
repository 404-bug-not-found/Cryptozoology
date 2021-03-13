package com.galvanize.Cryptozoology;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<AnimalDTO> fetchAll(){
        return animalRepository.findAll()
                .stream()
                .map(animalEntity -> {
                    return new AnimalDTO(animalEntity.getName(),animalEntity.getType(),animalEntity.getMood());
                })
                .collect(Collectors.toList());

    }
}
