package com.galvanize.Cryptozoology;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AnimalDTO {

    String name;
    String type;
    String mood = "unhappy";

/*    public AnimalDTO(String n, String t) {
        this.name = n;
        this.type = t;
    }*/
}
