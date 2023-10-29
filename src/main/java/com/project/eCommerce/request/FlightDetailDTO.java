package com.project.eCommerce.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class FlightDetailDTO {


    @NotBlank
    private Long flight_id;

    @NotBlank
    private LocalDate departureDate;
    @NotBlank
    private LocalTime departureTime;
    @NotBlank
    private Double durationInHrs;
}
