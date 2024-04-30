package org.example.doitone.controller;

import org.example.doitone.domain.Animal;
import org.example.doitone.domain.Cat;
import org.example.doitone.domain.Dog;
import org.example.doitone.domain.IntroduceResponse;
import org.example.doitone.domain.ListResponseWrapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjController1 {
    private static Map<Long, Animal> zoo = new HashMap<>();
    private static Long animalSequence = 0L;

    @PostMapping("/v1/dog") // 요청을 받는 주소. localhost:8080/v1/dog
    public ResponseEntity addDog(@RequestBody Dog dog) {
        // json으로 들어온 데이터 --역직렬화--> 객체로 처리 --직렬화--> json 데이터 반환
        // spring은, json으로 들어온 데이터를 객체로 변환(역직렬화)해주는 jackson이란 모듈을 포함
        // 객체의 직렬화는 public 접근제한의 getXXX 메서드를 모두 읽어서 처리한다.
        dog.setAnimalId(animalSequence++); // dog 1, 2 객체를 구분. 사물함 번호
        zoo.put(dog.getAnimalId(), dog);
        return ResponseEntity.ok(dog);
    }

    @PostMapping("/v1/cat")
    public ResponseEntity addCat(@RequestBody Cat cat) {
        Long newAnimalId = (long) zoo.size() + 1;
        cat.setAnimalId(newAnimalId);
        zoo.put(newAnimalId, cat);

        return ResponseEntity.ok(cat);
    }

    @GetMapping("/v1/zoo/{animalId}")
    public ResponseEntity getAnimalById(@PathVariable Long animalId) {
        return ResponseEntity.ok(zoo.get(animalId));
    }


    @GetMapping("/v1/zoo")
    public ResponseEntity getZoo() {
        return ResponseEntity.ok(zoo);
    }

    @GetMapping("/v1/zoo/introduce")
    public ResponseEntity introduceAllAnimals() {
        Map<Long, String> introductions = new HashMap<>();
        for (Animal animal : zoo.values()) {
            introductions.put(animal.getAnimalId(), animal.introduce());
        }

        return ResponseEntity.ok(introductions);
    }

    @GetMapping("/v1/zoo/introduce2")
    public ResponseEntity introduceAllAnimals2() {
        List<IntroduceResponse> result = zoo.values().stream()
                .map(animal -> {
                    IntroduceResponse response = new IntroduceResponse(animal.getName(), animal.introduce());
                    return response;
                })
                .toList();

        ListResponseWrapper<IntroduceResponse> response = new ListResponseWrapper<>(result);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/v1/zoo/search")
    public ResponseEntity searchAnimalByName(@RequestParam String name) {
        List<Animal> result = zoo.values().stream()
                .filter(animal -> animal.getName().contains(name))
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }

    @GetMapping("/v1/zoo/search2")
    public ResponseEntity searchAnimalByName2(@RequestParam String name) {
        List<Animal> searchResult = zoo.values().stream()
                .filter(animal -> animal.getName().contains(name))
                .toList();

        ListResponseWrapper<Animal> response = new ListResponseWrapper<>(searchResult);

        return ResponseEntity.ok(response);
    }

}
