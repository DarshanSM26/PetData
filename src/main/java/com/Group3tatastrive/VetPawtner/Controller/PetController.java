package com.Group3tatastrive.VetPawtner.Controller;

import com.Group3tatastrive.VetPawtner.Entity.Pet;
import com.Group3tatastrive.VetPawtner.Service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo/pet")
// Spring Boot example
@CrossOrigin(origins = "http://127.0.0.1:5500")

public class PetController {

    /*@Autowired
    private PetService petService;

    @GetMapping("/fetching")
    public ResponseEntity<List<Pet>> getalldetailsofPets(){
        return ResponseEntity.ok(petService.getAllPets());
    }

    @PostMapping
    public ResponseEntity<Pet> insertalldetailsofPet(@RequestBody Pet pet){
        return ResponseEntity.ok(petService.savePet(pet));
    }

    @PutMapping("{id}")
    public ResponseEntity<Pet> Updatealldetails(@PathVariable Integer id, @RequestBody Pet pet){
        return ResponseEntity.ok(petService.updatePet(id, pet));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Pet> deletealldetails(@PathVariable Integer id){
        return ResponseEntity.ok(petService.deletePet(id));
    }*/



    @Autowired
    private PetService petService;

    // -------- Get all Pets --------
    @GetMapping("/fetching")
    public ResponseEntity<List<Pet>> getAllPets() {
        return ResponseEntity.ok(petService.getAllPets());
    }

    // -------- Add Pet --------
    @PostMapping
    public ResponseEntity<Pet> addPet(@RequestBody Pet pet) {
        return ResponseEntity.ok(petService.savePet(pet));
    }

    // -------- Update Pet --------
    @PutMapping("/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable Integer id, @RequestBody Pet pet) {
        return ResponseEntity.ok(petService.updatePet(id, pet));
    }

    // -------- Delete Pet --------
    @DeleteMapping("/{id}")
    public ResponseEntity<Pet> deletePet(@PathVariable Integer id) {
        return ResponseEntity.ok(petService.deletePet(id));
    }
}
