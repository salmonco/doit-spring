package org.example.doitone.domain;

import java.time.LocalDate;

public class Dog extends Animal{
    private DogBreed breed;

    public Dog(Long animalId, String name, LocalDate birthDate, DogBreed breed) {
        super(animalId, name, birthDate);
        this.breed = breed;
    }

    @Override
    public String introduce() {
        int age = LocalDate.now().getYear() - this.birthDate.getYear();
        return "My name is " + this.name + " and I am a " + this.breed + " dog." + " My age is " + age + " years.";
    }
}

enum DogBreed {
    LABRADOR,
    GOLDENRETRIEVER,
    POODLE,
    BEAGLE,
    BULLDOG;
}
