package com.project.eCommerce.entity;


import com.project.eCommerce.Enum.BookedStatus;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class BookingDetails {
    Long id;
    String bookingId;
    User user;
    Flight flight;
    BookedStatus bookingStatus;
    Transaction transaction;
    String remarks;
}
