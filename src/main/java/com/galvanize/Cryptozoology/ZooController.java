package com.galvanize.Cryptozoology;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Target;

@RestController
public class ZooController {



    @PostMapping("animals")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAnimals(@RequestBody AnimalDTO animalDTO){

    }

    @GetMapping("animals")
    @ResponseStatus(HttpStatus.OK)
    public String getAnimals(){
        return "[{}]";
    }
}
