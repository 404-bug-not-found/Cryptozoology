package com.galvanize.Cryptozoology;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Target;
import java.util.ArrayList;

@RestController
public class ZooController {

    //@Autowired
    ArrayList<AnimalDTO> animalList;

    ZooController(){
        animalList = new ArrayList<>();
    }

    @PostMapping("animal")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAnimals(@RequestBody AnimalDTO animalDTO){

        animalList.add(animalDTO);

    }

    @GetMapping("animals")
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<AnimalDTO> getAnimals(){
        //return "[{},{}]";
        return this.animalList;
    }


    @PutMapping("feedAnimal")
    @ResponseStatus(HttpStatus.OK)
    public void feedAnimal(){

        animalList.get(0).mood="happy";

    }
}
