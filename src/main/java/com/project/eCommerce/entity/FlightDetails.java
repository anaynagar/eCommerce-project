package com.project.eCommerce.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
@Entity
@Table(name = "flight_details")
public class FlightDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate departureDate;
    private  LocalTime departureTime;
    private Double durationInHrs;

}
