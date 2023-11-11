package com.project.eCommerce.controller;


import com.project.eCommerce.CSTMException;
import com.project.eCommerce.request.FlightDetailDTO;
import com.project.eCommerce.response.FlightResponse;
import com.project.eCommerce.service.FlightDetailService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v0/flight-details")
@RequiredArgsConstructor
public class FlightDetailController {
    private static final Logger logger = LoggerFactory.getLogger(FlightController.class);
    private final FlightDetailService flightDetailService;

    @PostMapping(value = "/add-flight-detail",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FlightResponse> addFlightDetail(@Valid @RequestBody List<FlightDetailDTO> request,
                                                          @RequestParam Long flightId) throws CSTMException {
        logger.info("request received for creatingFlightData:{}", request);
        var response = flightDetailService.createFlightDetails(request,flightId);
        return ResponseEntity.ok(response);
    }
}
