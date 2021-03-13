package com.galvanize.Cryptozoology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDTO {

    String name;
    String type;

/*    public AnimalDTO(String n, String t) {
        this.name = n;
        this.type = t;
    }*/
}
