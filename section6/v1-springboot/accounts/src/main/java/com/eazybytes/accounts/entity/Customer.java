package com.eazybytes.accounts.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * This class is a JPA entity that represents a customer.
 * It extends BaseEntity that provides createdAt and updatedAt fields.
 * The class is annotated with Lombok annotations to automatically generate getter, setter, and toString methods.
 * It also has a constructor and a no-argument constructor.
 * The customerId field is annotated with @Id and is the primary key of the customer.
 * The customerId field is annotated with @GeneratedValue(strategy=GenerationType.IDENTITY) to indicate that the id should be automatically generated.
 */
@Entity @Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Customer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;

    @Column(name = "mobile_number")
    private  String mobileNumber;

}
