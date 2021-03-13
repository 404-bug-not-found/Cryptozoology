package com.galvanize.Cryptozoology;


import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AnimalServiceTest {

    @Mock
    AnimalRepository mockAnimalRepository;

    @InjectMocks
    AnimalService subject;

    @Test
    public void create() {
        AnimalDTO animalDTO = new AnimalDTO("Tiger", "walking", "unhappy");
        subject.create(animalDTO);
        verify(mockAnimalRepository).save(
                new AnimalEntity("Tiger", "walking", "unhappy")
        );
    }

    @Test
    public void fetchAll(){
        //Setup
        //AnimalEntity animalEntity = new AnimalEntity("Tiger", "walking", "unhappy");
        when(mockAnimalRepository.findAll()).thenReturn(
                List.of(
                        new AnimalEntity("Tiger", "walking", "unhappy"),
                        new AnimalEntity("Dolphin", "flying", "happy")
                )
        );

        //Exercise
        List<AnimalDTO> actual = subject.fetchAll();

        //Assert
        assertThat(actual).isEqualTo(
                List.of(
                        new AnimalDTO("Tiger", "walking", "unhappy"),
                        new AnimalDTO("Dolphin", "flying", "happy")
                )
        );
    }
}
