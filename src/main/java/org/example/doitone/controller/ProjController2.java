package org.example.doitone.controller;

import org.example.doitone.domain.Cat;
import org.example.doitone.domain.Dog;
import org.example.doitone.service.ProjService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjController2 {

    private final ProjService projService;

    public ProjController2(ProjService projService) {
        this.projService = projService;
    }

    @PostMapping("/v2/dog")
    public ResponseEntity addDog(@RequestBody Dog dog) {
        return ResponseEntity.ok(projService.addDog(dog));
    }

    @PostMapping("/v2/cat")
    public ResponseEntity addCat(@RequestBody Cat cat) {
        return ResponseEntity.ok(projService.addCat(cat));
    }

    @GetMapping("/v2/zoo/{animalId}")
    public ResponseEntity getAnimalById(@PathVariable Long animalId) {
        return ResponseEntity.ok(projService.getAnimalById(animalId));
    }

    @GetMapping("/v2/zoo")
    public ResponseEntity getZoo() {
        return ResponseEntity.ok(projService.getZoo());
    }

    @GetMapping("/v2/zoo/introduce")
    public ResponseEntity introduceAllAnimals() {
        return ResponseEntity.ok(projService.introduceAllAnimals());
    }

    @GetMapping("/v2/zoo/introduce2")
    public ResponseEntity introduceAllAnimals2() {
        return ResponseEntity.ok(projService.introduceAllAnimals2());
    }

    @GetMapping("/v2/zoo/search")
    public ResponseEntity searchAnimalByName(@RequestParam String name) {
        return ResponseEntity.ok(projService.searchAnimalByName(name));
    }

    @GetMapping("/v2/zoo/search2")
    public ResponseEntity searchAnimalByName2(@RequestParam String name) {
        return ResponseEntity.ok(projService.searchAnimalByName2(name));
    }
}
