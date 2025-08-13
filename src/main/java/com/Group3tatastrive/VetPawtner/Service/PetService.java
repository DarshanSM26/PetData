package com.Group3tatastrive.VetPawtner.Service;

import com.Group3tatastrive.VetPawtner.Entity.Pet;
import com.Group3tatastrive.VetPawtner.Repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public List<Pet> getAllPets() {
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
    }

}
