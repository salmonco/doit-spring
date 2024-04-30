package org.example.doitone.service;

import org.example.doitone.domain.Animal;
import org.example.doitone.domain.Cat;
import org.example.doitone.domain.Dog;
import org.example.doitone.domain.IntroduceResponse;
import org.example.doitone.domain.ListResponseWrapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ProjService {
    private static Map<Long, Animal> zoo = new HashMap<>();
    private static Long animalSequence = 0L;

    public Dog addDog(Dog dog) {
        dog.setAnimalId(animalSequence++);
        zoo.put(dog.getAnimalId(), dog);
        return dog;
    }

    public Cat addCat(Cat cat) {
        Long newAnimalId = (long) zoo.size() + 1;
        cat.setAnimalId(newAnimalId);
        zoo.put(newAnimalId, cat);
        return cat;
    }

    public Animal getAnimalById(Long animalId) {
        return zoo.get(animalId);
    }

    public Map<Long, Animal> getZoo() {
        return zoo;
    }

    public Map<Long, String> introduceAllAnimals() {
        Map<Long, String> introductions = new HashMap<>();
        for (Animal animal : zoo.values()) {
            introductions.put(animal.getAnimalId(), animal.introduce());
        }
        return introductions;
    }

    public List<IntroduceResponse> introduceAllAnimals2() {
        return zoo.values().stream()
                .map(animal -> {
                    IntroduceResponse response = new IntroduceResponse(animal.getName(), animal.introduce());
                    return response;
                })
                .collect(Collectors.toList());
    }

    public List<Animal> searchAnimalByName(String name) {
        return zoo.values().stream()
                .filter(animal -> animal.getName().contains(name))
                .collect(Collectors.toList());
    }

    public ListResponseWrapper<Animal> searchAnimalByName2(String name) {
        List<Animal> searchResult = zoo.values().stream()
                .filter(animal -> animal.getName().contains(name))
                .collect(Collectors.toList());
        return new ListResponseWrapper<>(searchResult);
    }
}
