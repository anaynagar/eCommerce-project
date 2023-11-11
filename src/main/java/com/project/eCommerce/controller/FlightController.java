package com.project.eCommerce.controller;


import com.project.eCommerce.CSTMException;
import com.project.eCommerce.request.FlightCreateRequest;
import com.project.eCommerce.request.FlightUpdateRequest;
import com.project.eCommerce.response.FlightResponse;
import com.project.eCommerce.service.FlightService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v0/flight")
@Slf4j
@RequiredArgsConstructor
public class FlightController {
    private static final Logger logger = LoggerFactory.getLogger(FlightController.class);
    private final FlightService flightService;

    @PostMapping(value = "/create-flight", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FlightResponse> addFlightData(@Valid @RequestBody FlightCreateRequest request) {
        logger.info("request received for creatingFlightData:{}", request);
        var response = flightService.createFlight(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightResponse> getById(@PathVariable Long id) throws CSTMException {
        logger.info("request received for getting flight data by id:{}", id);
        var response = flightService.getFlightById(id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws CSTMException {
        logger.info("request recceived for deleting flight");
        flightService.deleteFlightById(id);

        return ResponseEntity.ok("Successfully deleted the flight entry");
    }

    @PatchMapping("/update-flight")
    public ResponseEntity<FlightResponse> updateById(@RequestParam Long id, @RequestBody
    FlightUpdateRequest flightUpdateRequest) throws CSTMException {
        logger.info("update flight");

        var response = flightService.updateById(id, flightUpdateRequest);
        return ResponseEntity.ok(response);
    }


}
