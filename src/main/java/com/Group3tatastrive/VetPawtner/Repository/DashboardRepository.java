package com.Group3tatastrive.VetPawtner.Repository;

import com.Group3tatastrive.VetPawtner.Entity.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardRepository extends JpaRepository<Dashboard, Integer> {
}