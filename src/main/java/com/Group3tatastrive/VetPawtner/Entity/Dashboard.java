package com.Group3tatastrive.VetPawtner.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dashboard")
public class Dashboard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dashboard_id")
    private Integer dashboardId;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    @Column(name = "total_pets")
    private Integer totalPets;

    @Column(name = "total_orders")
    private Integer totalOrders;
}
