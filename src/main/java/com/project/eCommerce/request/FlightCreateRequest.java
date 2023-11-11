package com.project.eCommerce.request;

import com.project.eCommerce.entity.FlightDetails;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.List;

@Data
public class FlightCreateRequest {

    @NotNull
    private String flightName;

    @NotNull
    private String src;
    @NotNull
    private String destination;

    @NotEmpty
    private List<FlightDetailDTO> flightDetails;

    private boolean availabilityStatus;
}
