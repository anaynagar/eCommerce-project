package com.project.eCommerce.entity;


import com.project.eCommerce.Enum.BookedStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Data
//on hold
public class BookingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookingId;
    private User user;
    private Flight flight;
    private BookedStatus bookingStatus;
//    private Transaction transaction;
    private String remarks;
}
