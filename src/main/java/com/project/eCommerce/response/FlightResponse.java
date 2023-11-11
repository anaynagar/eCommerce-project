package com.project.eCommerce.response;

import com.project.eCommerce.entity.FlightDetails;
import com.project.eCommerce.request.FlightDetailDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class FlightResponse {
//    private String flightId;
    private String flightName;
    private String src;
    private String destination;

    private List<FlightDetails> flightDetails;


    private boolean availabilityStatus;


}
