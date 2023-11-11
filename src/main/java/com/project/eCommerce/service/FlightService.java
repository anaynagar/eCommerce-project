package com.project.eCommerce.service;


import com.project.eCommerce.CSTMException;
import com.project.eCommerce.Utils.StringUtils;
import com.project.eCommerce.entity.Flight;
import com.project.eCommerce.entity.FlightDetails;
import com.project.eCommerce.repository.FlightRepository;
import com.project.eCommerce.request.FlightCreateRequest;
import com.project.eCommerce.request.FlightDetailDTO;
import com.project.eCommerce.request.FlightUpdateRequest;
import com.project.eCommerce.response.FlightResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final ModelMapper modelMapper;
    private final FlightRepository flightRepository;

    public FlightResponse createFlight(FlightCreateRequest request) {
        Flight flight = modelMapper.map(request, Flight.class);
        flightRepository.save(flight);

        FlightResponse flightResponse = modelMapper.map(flight, FlightResponse.class);
        return flightResponse;
    }

    public FlightResponse getFlightById(Long id) throws CSTMException {
        Optional<Flight> flightOptional = flightRepository.findById(id);
        if (flightOptional.isEmpty())
            throw new CSTMException("Flight doesnt exists for given id", HttpStatus.NOT_FOUND);
        Flight flight = flightOptional.get();
        return modelMapper.map(flight, FlightResponse.class);
    }

    public void deleteFlightById(Long id) throws CSTMException {
        Optional<Flight> flightOptional = flightRepository.findById(id);
        if (flightOptional.isEmpty())
            throw new CSTMException("Flight doesnt exists for given id", HttpStatus.NOT_FOUND);

        flightRepository.deleteById(id);
    }

    public FlightResponse updateById(Long id, FlightUpdateRequest flightUpdateRequest) throws CSTMException {
        Optional<Flight> flightOptional = flightRepository.findById(id);
        if (flightOptional.isEmpty())
            throw new CSTMException("Flight doesnt exists for given id", HttpStatus.NOT_FOUND);

        Flight flight = flightOptional.get();
        //check overlapping condtions for flight.
        if (StringUtils.isNotBlank(flightUpdateRequest.getSrc())) flight.setSrc(flightUpdateRequest.getSrc());
        if (StringUtils.isNotBlank(flightUpdateRequest.getDestination())) flight.setDestination
                (flightUpdateRequest.getDestination());
        if (flightUpdateRequest.getAvailabilityStatus() != null) flight.setAvailabilityStatus(flightUpdateRequest.
                getAvailabilityStatus());

        if (!flightUpdateRequest.getFlightDetails().isEmpty()) {
            Set<FlightDetailDTO> newFlightDetails = flightUpdateRequest.getFlightDetails();

            Set<FlightDetailDTO> existingDTO = flight.getFlightDetails().stream().map(detail ->
                    modelMapper.map(detail, FlightDetailDTO.class)).collect(Collectors.toSet());

            //take common one out
            newFlightDetails = newFlightDetails.stream().filter(flightDTO -> existingDTO.contains(flightDTO)).
                    collect(Collectors.toSet());
            existingDTO.addAll(newFlightDetails);

            var flightDetailsSet =
                    existingDTO.stream().map(dto -> modelMapper.map(dto, FlightDetails.class)).collect(Collectors.toSet());
            flight.setFlightDetails(flightDetailsSet);
        }

        flightRepository.save(flight);
        return modelMapper.map(flight,FlightResponse.class);
    }
}
