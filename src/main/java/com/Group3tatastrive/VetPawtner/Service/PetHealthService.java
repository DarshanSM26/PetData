package com.Group3tatastrive.VetPawtner.Service;

import com.Group3tatastrive.VetPawtner.Entity.Booking;
import com.Group3tatastrive.VetPawtner.Entity.Pet;
import com.Group3tatastrive.VetPawtner.Entity.PetHealth;
import com.Group3tatastrive.VetPawtner.Repository.BookingRepository;
import com.Group3tatastrive.VetPawtner.Repository.PetHealthRepository;
import com.Group3tatastrive.VetPawtner.Repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetHealthService {
    @Autowired
    PetHealthRepository petHealthRepository;
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    PetRepository petRepository;

   /* public List<PetHealth> getAllData() {
        return petHealthRepository.findAll();
    }

    public PetHealth insertData(Long bookingId, PetHealth petHealth) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        // Automatically assign pet from booking
        Pet pet = booking.getPet();
        petHealth.setBooking(booking);
        petHealth.setPet(pet);

        return petHealthRepository.save(petHealth);
    }

    public PetHealth updateData(Long healthId, PetHealth petHealth) {
        PetHealth existing = petHealthRepository.findById(healthId)
                .orElseThrow(() -> new RuntimeException("PetHealth not found"));

        existing.setCheckup_date(petHealth.getCheckup_date());
        existing.setWeight(petHealth.getWeight());
        existing.setTemperature(petHealth.getTemperature());
        existing.setNotes(petHealth.getNotes());
        existing.setVet_name(petHealth.getVet_name());

        return petHealthRepository.save(existing);
    }

    public void deleteData(Long healthId) {
        PetHealth existing = petHealthRepository.findById(healthId)
                .orElseThrow(() -> new RuntimeException("PetHealth not found"));
        petHealthRepository.delete(existing);
    }*/

   public List<PetHealth> GetAllData() {
        return petHealthRepository.findAll();
    }

    public PetHealth insertdata(Integer petId, PetHealth petHealth) {
        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new RuntimeException("Pet not found"));

        petHealth.setPet(pet);
        return petHealthRepository.save(petHealth);
    }

    public PetHealth updatedata(Integer petId, long health_id, PetHealth petHealth) {
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
    }


    public PetHealth deletedata(long healthId) {
        PetHealth petHealth1 = petHealthRepository.findById(healthId).orElse(null);
        if (petHealth1!=null){
            petHealthRepository.delete(petHealth1);
        }
        return petHealth1;
    }


    public List<PetHealth> getHealthHistoryForPet(Integer petId) {
        return petHealthRepository.findByPetPetId(petId);
    }
}
