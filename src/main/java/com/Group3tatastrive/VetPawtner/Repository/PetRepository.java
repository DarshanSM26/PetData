package com.Group3tatastrive.VetPawtner.Repository;

import com.Group3tatastrive.VetPawtner.Entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {
}
