package com.project.eCommerce.entity;


import com.project.eCommerce.Enum.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String txnId;
    PaymentStatus paymentStatus;
    String remarks;
}
