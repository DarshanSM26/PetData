package com.Group3tatastrive.VetPawtner.Service;

import com.Group3tatastrive.VetPawtner.Entity.Pet;
import com.Group3tatastrive.VetPawtner.Entity.User;
import com.Group3tatastrive.VetPawtner.Repository.PetRepository;
import com.Group3tatastrive.VetPawtner.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;
    @Autowired
    UserRepository userRepository;

   /* public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }

    public Pet updatePet(Integer id, Pet pet) {
        Pet pet1 = petRepository.findById(id).orElse(null);

            pet1.setUser(pet.getUser());
            pet1.setName(pet.getName());
            pet1.setBreed(pet.getBreed());
            pet1.setGender(pet.getGender());
            pet1.setDob(pet.getDob());
            pet1.setVaccinationDetails(pet.getVaccinationDetails());
            return petRepository.save(pet1);
    }


    public Pet deletePet(Integer id) {
        Pet pet = petRepository.findById(id).orElse(null);
        if (pet != null) {
            petRepository.delete(pet);
        }
        return pet;
    }*/

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Pet savePet(Pet pet) {
        if (pet.getUser() != null && pet.getUser().getId() != null) {
            User user = userRepository.findById(pet.getUser().getId())
                    .orElseThrow(() -> new RuntimeException("User not found with id " + pet.getUser().getId()));
            pet.setUser(user); // ✅ attach managed user entity
        }
        return petRepository.save(pet);
    }

    public Pet updatePet(Integer id, Pet pet) {
        Pet pet1 = petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet not found with id " + id));

        if (pet.getUser() != null && pet.getUser().getId() != null) {
            User user = userRepository.findById(pet.getUser().getId())
                    .orElseThrow(() -> new RuntimeException("User not found with id " + pet.getUser().getId()));
            pet1.setUser(user);
        }

        pet1.setName(pet.getName());
        pet1.setBreed(pet.getBreed());
        pet1.setGender(pet.getGender());
        pet1.setDob(pet.getDob());
        pet1.setVaccinationDetails(pet.getVaccinationDetails());

        return petRepository.save(pet1);
    }

    public Pet deletePet(Integer id) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet not found with id " + id));
        petRepository.delete(pet);
        return pet;
    }

}
