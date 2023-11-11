package com.project.eCommerce.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class FlightDetailDTO {


    @NotBlank
    private LocalDate departureDate;
    @NotBlank
    private LocalTime departureTime;
    @NotBlank
    private Double durationInHrs;

    @Min(1)
    private Double amount;
}
