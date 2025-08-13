package com.Group3tatastrive.VetPawtner.Controller;

import com.Group3tatastrive.VetPawtner.Entity.Pet;
import com.Group3tatastrive.VetPawtner.Service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping("Feteching")
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
    }
}
