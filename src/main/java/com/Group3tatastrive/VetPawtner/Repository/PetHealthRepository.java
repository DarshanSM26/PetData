package com.Group3tatastrive.VetPawtner.Repository;

import com.Group3tatastrive.VetPawtner.Entity.PetHealth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetHealthRepository extends JpaRepository<PetHealth,Long> {
    List<PetHealth> findByPetPetId(Integer petId);
}
