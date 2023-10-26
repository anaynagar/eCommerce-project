package com.project.eCommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Flight {
    Long id;
    String flightId;
    String flightName;
//    String srcDestination;
    String src;
    String destination;

    @OneToMany
    @JoinColumn(name = "flight_departure_details")
    List<FlightDepartureDetail> flightDepartureDetails;
    boolean availabilityStatus;
    boolean deleted;
}
