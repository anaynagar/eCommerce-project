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
import java.util.Set;

@Service
@RequiredArgsConstructor
public class FlightDetailService {
    private final ModelMapper modelMapper;
    private final FlightRepository flightRepository;

}
