package com.project.eCommerce.service;


import com.project.eCommerce.entity.Flight;
import com.project.eCommerce.repository.FlightRepository;
import com.project.eCommerce.request.FlightCreateRequest;
import com.project.eCommerce.response.FlightResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final ModelMapper modelMapper;
    private final FlightRepository flightRepository;
    public FlightResponse createFlight(FlightCreateRequest request) {
        Flight flight = modelMapper.map(request,Flight.class);
        flightRepository.save(flight);
        FlightResponse flightResponse = modelMapper.map(flight, FlightResponse.class);
        return flightResponse;
    }

}
