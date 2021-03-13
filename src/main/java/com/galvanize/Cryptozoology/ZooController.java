package com.galvanize.Cryptozoology;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ZooController {

    //@Autowired
    //ArrayList<AnimalDTO> animalList;

    AnimalService animalService;

//    ZooController(){
//        animalList = new ArrayList<>();
//    }

    public ZooController(AnimalService animalService){
        this.animalService=animalService;
    }

    @PostMapping("animal")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAnimals(@RequestBody AnimalDTO animalDTO){

        //animalList.add(animalDTO);
        this.animalService.create(animalDTO);

    }

    @GetMapping("animals")
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalDTO> getAnimals(){
        //return "[{},{}]";
        return this.animalService.fetchAll();
    }


//    @PutMapping("feedAnimal")
//    @ResponseStatus(HttpStatus.OK)
//    public void feedAnimal(){
//        animalList.get(0).mood="happy";
//    }
}
