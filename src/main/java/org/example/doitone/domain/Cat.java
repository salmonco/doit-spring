package org.example.doitone.domain;

import java.time.LocalDate;

public class Cat extends Animal{
    private CatBreed breed;

    public Cat(Long animalId, String name, LocalDate birthDate, CatBreed breed) {
        super(animalId, name, birthDate);
        this.breed = breed;
    }

    @Override
    public String introduce() {
        int age = LocalDate.now().getYear() - this.birthDate.getYear();
        return "My name is " + this.name + " and I am a " + this.breed + " cat." + " My age is " + age + " years.";
    }
}


enum CatBreed {
    PERSIAN,
    SIAMESE,
    BENGAL,
    RAGDOLL,
    SCOTTISHFOLD;
}
