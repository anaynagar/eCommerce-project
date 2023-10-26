package com.project.eCommerce.Enum;


import jakarta.persistence.Enumerated;
import lombok.Data;

public enum BookedStatus {

    SUCCESS("SUCCESS"),
    FAILURE("FAILURE"),
    IN_PROGRESS("IN_PROGRESS");

    final String name;
    BookedStatus(String name){
        this.name = name;
    }

}
