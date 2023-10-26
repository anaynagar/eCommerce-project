package com.project.eCommerce.entity;


import com.project.eCommerce.Enum.PaymentStatus;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Transaction {
    Long id;
    String txnId;
    PaymentStatus paymentStatus;
    String remarks;
}
