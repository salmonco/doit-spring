package org.example.doitone.domain;

import java.time.LocalDate;
import lombok.Getter;

@Getter
public abstract class Animal {
    protected Long animalId;
    protected String name;
    protected LocalDate birthDate;

    protected Animal(Long animalId, String name, LocalDate birthDate) {
        this.animalId = animalId;
        this.name = name;
        this.birthDate = birthDate;
    }

    public abstract String introduce();

    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
    }
}
