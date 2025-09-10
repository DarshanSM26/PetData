package com.Group3tatastrive.VetPawtner.Controller;

import com.Group3tatastrive.VetPawtner.Entity.Pet;
import com.Group3tatastrive.VetPawtner.Entity.PetHealth;
import com.Group3tatastrive.VetPawtner.Repository.PetHealthRepository;
import com.Group3tatastrive.VetPawtner.Repository.PetRepository;
import com.Group3tatastrive.VetPawtner.Service.PetHealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("demo/pet-health")
// Spring Boot example
@CrossOrigin(origins = {"http://127.0.0.1:5500","http://127.0.0.1:5501"})
public class PetHealthController {
    @Autowired
    PetRepository petRepository;
    @Autowired
    PetHealthRepository petHealthRepository;


    @Autowired
    PetHealthService petHealthService;

    @GetMapping
    public ResponseEntity<List<PetHealth>> GetAllData() {
        return ResponseEntity.ok(petHealthService.GetAllData());
    }

    /*@PostMapping()
    public PetHealth insertdata(@RequestBody PetHealth petHealth){
        return petHealthRepository.save(petHealth);
    }*/

    /*@PostMapping("/{petId}")
    public PetHealth insert(@PathVariable Integer petId, @RequestBody PetHealth petHealth) {
        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new RuntimeException("Pet not found"));
        petHealth.setPet(pet);
        return petHealthRepository.save(petHealth);
    }*/

    @PostMapping("/{petId}")
    public ResponseEntity<PetHealth> insertdata(@PathVariable Integer petId, @RequestBody PetHealth petHealth) {
        return ResponseEntity.ok(petHealthService.insertdata(petId, petHealth));
    }

    @GetMapping("/{petId}")
    public ResponseEntity<List<PetHealth>> getHealthHistoryByPetId(@PathVariable Integer petId) {
        List<PetHealth> history = petHealthService.getHealthHistoryForPet(petId);
        return ResponseEntity.ok(history);
    }


   /* @PutMapping("/{petId}/{health_id}")
    public PetHealth updatedata(@PathVariable Integer petId, @PathVariable long health_id, @RequestBody PetHealth petHealth){
        PetHealth petHealth1 = petHealthRepository.findById(health_id)
                .orElseThrow(() -> new RuntimeException("PetHealth not found with id " + health_id));

        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new RuntimeException("Pet not found with id " + petId));


        petHealth1.setPet(pet);
        petHealth1.setCheckup_date(petHealth.getCheckup_date());
        petHealth1.setWeight(petHealth.getWeight());
        petHealth1.setTemperature(petHealth.getTemperature());
        petHealth1.setNotes(petHealth.getNotes());
        petHealth1.setVet_name(petHealth.getVet_name());
        return petHealthRepository.save(petHealth1);
    }*/


   @PutMapping("/{petId}/{health_id}")
    public ResponseEntity<PetHealth> updatedata(@PathVariable Integer petId, @PathVariable long health_id, @RequestBody PetHealth petHealth) {
        return ResponseEntity.ok(petHealthService.updatedata(petId, health_id, petHealth));
    }

   /* @DeleteMapping("{health_id}")
    public PetHealth deletedata(@PathVariable long health_id){
        PetHealth petHealth2 = petHealthRepository.findById(health_id).orElse(null);
        if (petHealth2!=null){
            petHealthRepository.delete(petHealth2);
        }
        return petHealth2;
    }*/

    @DeleteMapping("{health_id}")
    public ResponseEntity<PetHealth> deletedata(@PathVariable long health_id) {
        return ResponseEntity.ok(petHealthService.deletedata(health_id));
    }

   /* @GetMapping
    public ResponseEntity<List<PetHealth>> getAllData() {
        return ResponseEntity.ok(petHealthService.getAllData());
    }

    // Save new health record based on bookingId
    @PostMapping("/{bookingId}")
    public ResponseEntity<PetHealth> insertData(@PathVariable Long bookingId,
                                                @RequestBody PetHealth petHealth) {
        return ResponseEntity.ok(petHealthService.insertData(bookingId, petHealth));
    }

    // Update existing health record
    @PutMapping("/{healthId}")
    public ResponseEntity<PetHealth> updateData(@PathVariable Long healthId,
                                                @RequestBody PetHealth petHealth) {
        return ResponseEntity.ok(petHealthService.updateData(healthId, petHealth));
    }

    // Delete health record
    @DeleteMapping("/{healthId}")
    public ResponseEntity<Void> deleteData(@PathVariable Long healthId) {
        petHealthService.deleteData(healthId);
        return ResponseEntity.noContent().build();
    }*/
}
