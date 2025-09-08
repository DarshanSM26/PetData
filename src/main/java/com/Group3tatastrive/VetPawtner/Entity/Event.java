package com.Group3tatastrive.VetPawtner.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int event_id;
    @Column(name = "Name", nullable = true)
    private String event_name;
    @Column(name = "Price", nullable = true)
    private Double price;
    @Column(name = "Location",nullable = true)
    private String location;
    @Column(name = "Time", nullable = true)
    private String time;
    @Column(name = "Date",nullable = true)
    @Temporal(TemporalType.DATE)
    private Date date;
   /* @ManyToOne(optional = true)
    private User user;*/

    @ManyToOne(optional = true)
    @JoinColumn(name = "user_id")   // 👈 forces FK column name
    private User user;

}
