package com.project.eCommerce.request;
import lombok.Data;

import java.util.Set;

@Data
public class FlightUpdateRequest {
    private String src;
    private String destination;
    private Set<FlightDetailDTO> flightDetails;

    private Boolean availabilityStatus;
}
