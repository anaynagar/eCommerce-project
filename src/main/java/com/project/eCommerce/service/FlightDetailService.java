package com.project.eCommerce.service;

import com.project.eCommerce.CSTMException;
import com.project.eCommerce.entity.Flight;
import com.project.eCommerce.entity.FlightDetails;
import com.project.eCommerce.repository.FlightRepository;
import com.project.eCommerce.request.FlightDetailDTO;
import com.project.eCommerce.response.FlightResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlightDetailService {
    private final ModelMapper modelMapper;
    private final FlightRepository flightRepository;
    public FlightResponse createFlightDetails(List<FlightDetailDTO> request, Long flightId) throws CSTMException {
        Optional<Flight> flightOptional = flightRepository.findById(flightId);
        if(flightOptional.isEmpty()){
            throw new CSTMException("Flight data not found, give a valid id", HttpStatus.NOT_FOUND);
        }

        Flight flight = flightOptional.get();

        List<FlightDetails> flightDetailsList = flight.getFlightDetails();
        for(var dto:request){
            flightDetailsList.add(modelMapper.map(dto,FlightDetails.class));
        }

        flight.setFlightDetails(flightDetailsList);

        flightRepository.save(flight);
        return modelMapper.map(flight, FlightResponse.class);
    }
}
