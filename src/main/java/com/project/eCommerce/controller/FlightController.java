package com.project.eCommerce.controller;


import com.project.eCommerce.request.FlightCreateRequest;
import com.project.eCommerce.response.FlightResponse;
import com.project.eCommerce.service.FlightService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v0/flight")
@Slf4j
@RequiredArgsConstructor
public class FlightController {
    private static final Logger logger = LoggerFactory.getLogger(FlightController.class);
    private final FlightService flightService;

    @PostMapping(value = "/create-flight",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FlightResponse> addFlightData(@Valid @RequestBody FlightCreateRequest request){
        logger.info("request received for creatingFlightData:{}", request);
        var response = flightService.createFlight(request);
        return ResponseEntity.ok(response);
    }


}
