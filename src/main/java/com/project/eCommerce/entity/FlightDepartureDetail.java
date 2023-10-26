package com.project.eCommerce.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Table
@Entity
@Data
public class FlightDepartureDetail {
    Long id;
    LocalDate departureDate;
    LocalTime departureTime;
    Double durationInHrs;
    boolean deleted;
}
