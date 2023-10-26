package com.project.eCommerce.Enum;

public enum PaymentStatus {

    SUCCESS("SUCCESS"),
    FAILURE("FAILURE"),
    IN_PROGRESS("IN_PROGRESS"),
    REFUNDED("REFUNDED");

    final String name;
    PaymentStatus(String name){
        this.name = name;
    }
}
