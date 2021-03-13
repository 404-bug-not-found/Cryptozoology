package com.galvanize.Cryptozoology;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@EqualsAndHashCode
@Getter
@Setter
public class AnimalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String name;
    String type;
    String mood;

    public AnimalEntity(String n, String t, String m) {
        this.name = n;
        this.type = t;
        this.mood = m;
    }
}
