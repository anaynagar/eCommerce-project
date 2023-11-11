package com.project.eCommerce.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String flightName;
    private String src;
    private String destination;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flight")
    private Set<FlightDetails> flightDetails;

    private boolean availabilityStatus;
    private boolean deleted;
}
