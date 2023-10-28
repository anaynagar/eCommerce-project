package com.project.eCommerce.request;

import com.project.eCommerce.entity.FlightDetails;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightCreateRequest {

    @NotNull
    private String flightName;

    @NotNull
    private String src;
    @NotNull
    private String destination;

    @NotEmpty
    private List<FlightDetails> flightDetails;


    @NotNull
    private Double amount;

    private boolean availabilityStatus;
}
