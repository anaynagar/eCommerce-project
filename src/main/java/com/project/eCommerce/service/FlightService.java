package com.project.eCommerce.service;


import com.project.eCommerce.entity.Flight;
import com.project.eCommerce.repository.FlightRepository;
import com.project.eCommerce.request.FlightCreateRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final ModelMapper modelMapper;
    private final FlightRepository flightRepository;
    public void createFlight(FlightCreateRequest request) {
        Flight flight = modelMapper.map(request,Flight.class);
        flightRepository.save(flight);

    }


}
