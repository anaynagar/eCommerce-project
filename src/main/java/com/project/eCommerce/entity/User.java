package com.project.eCommerce.entity;


import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class User {
    Long id;
    String userName;
    String fwUserId;
    String email;
    String password;
}
