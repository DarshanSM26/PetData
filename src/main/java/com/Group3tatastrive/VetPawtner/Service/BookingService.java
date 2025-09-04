package com.Group3tatastrive.VetPawtner.Service;

import com.Group3tatastrive.VetPawtner.Entity.Booking;
import com.Group3tatastrive.VetPawtner.Entity.Pet;
import com.Group3tatastrive.VetPawtner.Repository.BookingRepository;
import com.Group3tatastrive.VetPawtner.Repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    PetRepository petRepository;

    public Booking saveBooking(Integer petId, Booking booking) {
        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new RuntimeException("Pet not found with ID: " + petId));
        booking.setPet(pet);
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllAppointments() {
        return bookingRepository.findAll();
    }

    public Booking getAppointmentById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with ID: " + id));
    }

    public Booking updateAppointment(Long id, Booking booking) {
        Booking existing = getAppointmentById(id);
        existing.setVetName(booking.getVetName());
        existing.setDate(booking.getDate());
        return bookingRepository.save(existing);
    }

    public void deleteAppointment(Long id) {
        bookingRepository.deleteById(id);
    }

    public List<String> getAllVetNames() {
        return bookingRepository.findAll()
                .stream()
                .map(Booking::getVetName)
                .distinct()
                .toList();
    }

    public List<Booking> getAppointmentsForVet(String vetName) {
        return bookingRepository.findByVetName(vetName);
    }
   /* public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }


    public Booking saveBooking(Integer  petId, Booking booking) {
        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new RuntimeException("Pet not found with ID: " + petId));
        booking.setPet(pet);
        return bookingRepository.save(booking);
    }*/
}
