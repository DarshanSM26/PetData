package com.Group3tatastrive.VetPawtner.Controller;

import com.Group3tatastrive.VetPawtner.Entity.Booking;
import com.Group3tatastrive.VetPawtner.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo/appointments")
public class BookingController {
    @Autowired
    BookingService bookingService;

  /*  @GetMapping
    public ResponseEntity<List<Booking>> getAllAppointments() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @PostMapping
    public ResponseEntity<Booking> createAppointment(@PathVariable Integer  petId, @RequestBody Booking booking) {
        return ResponseEntity.ok(bookingService.saveBooking(petId, booking));
    }*/

    @PostMapping("/{petId}")
    public ResponseEntity<Booking> createAppointment(@PathVariable Integer petId,
                                                     @RequestBody Booking booking) {
        return ResponseEntity.ok(bookingService.saveBooking(petId, booking));
    }

    // Get all appointments
    @GetMapping
    public ResponseEntity<List<Booking>> getAllAppointments() {
        return ResponseEntity.ok(bookingService.getAllAppointments());
    }

    // Get appointment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Booking> getAppointmentById(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.getAppointmentById(id));
    }

    // Update appointment
    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateAppointment(@PathVariable Long id,
                                                     @RequestBody Booking booking) {
        return ResponseEntity.ok(bookingService.updateAppointment(id, booking));
    }

    // Delete appointment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        bookingService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }

    // 🔹 Get all vet names (for dropdown in frontend)
    @GetMapping("/vets")
    public ResponseEntity<List<String>> getAllVetNames() {
        return ResponseEntity.ok(bookingService.getAllVetNames());
    }

    // 🔹 Get appointments for a specific vet (for vet dashboard)
    @GetMapping("/vet/{vetName}")
    public ResponseEntity<List<Booking>> getAppointmentsForVet(@PathVariable String vetName) {
        return ResponseEntity.ok(bookingService.getAppointmentsForVet(vetName));
    }


}
