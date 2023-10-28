package com.project.eCommerce.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String flightId;
    private String flightName;
    private String src;
    private String destination;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name= "flight_id")
    private List<FlightDetails> flightDetails;

    private Double amount;
    private boolean availabilityStatus;
    private boolean deleted;
}
