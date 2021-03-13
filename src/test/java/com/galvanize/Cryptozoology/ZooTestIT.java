package com.galvanize.Cryptozoology;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ZooTestIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void addAnimal() throws Exception{
        AnimalDTO animalDTO = new AnimalDTO("Tiger","walking","unhappy");

        mockMvc.perform(post("/animal")
                .content(objectMapper.writeValueAsString(animalDTO))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
    }

    @Test
    public void viewAnimals() throws Exception{
        //add animals
        AnimalDTO animalDTO1 = new AnimalDTO("Tiger","walking","unhappy");
        AnimalDTO animalDTO2 = new AnimalDTO("Dolphin","swimming","unhappy");

        mockMvc.perform(post("/animal")
                .content(objectMapper.writeValueAsString(animalDTO1))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());

        mockMvc.perform(post("/animal")
                .content(objectMapper.writeValueAsString(animalDTO2))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());

        mockMvc.perform(get("/animals")
        ).andExpect(status().isOk())
        .andExpect(jsonPath("length()").value(2))
        .andExpect(jsonPath("[0].name").value("Tiger"))
        .andExpect(jsonPath("[0].type").value("walking"))
        .andExpect(jsonPath("[1].name").value("Dolphin"))
        .andExpect(jsonPath("[1].type").value("swimming"));
    }

    @Test
    public void feedAnimal() throws Exception {

        //Add Animal
        AnimalDTO animalDTO1 = new AnimalDTO("Tiger", "walking","unhappy");
        mockMvc.perform(post("/animal")
                .content(objectMapper.writeValueAsString(animalDTO1))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());

        mockMvc.perform(get("/animals")
        ).andExpect(status().isOk())
                .andExpect(jsonPath("[0].mood").value("unhappy"));


            mockMvc.perform(put("/feedAnimal")
                    .content(objectMapper.writeValueAsString(animalDTO1))
                    .contentType(MediaType.APPLICATION_JSON)
            ).andExpect(status().isOk());

        mockMvc.perform(get("/animals")
        ).andExpect(status().isOk())
                .andExpect(jsonPath("[0].mood").value("happy"));


    }
}
