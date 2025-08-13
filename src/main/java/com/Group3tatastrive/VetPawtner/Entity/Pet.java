package com.Group3tatastrive.VetPawtner.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "petid")
    private Integer petId;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "breed", length = 50)
    private String breed;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "vaccination_details", columnDefinition = "TEXT")
    private String vaccinationDetails;

    public enum Gender {
        male,
        female,
        other
    }
}
