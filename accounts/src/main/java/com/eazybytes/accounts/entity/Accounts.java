package com.eazybytes.accounts.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * This class represents an account that belongs to a customer.
 * It is a JPA entity.
 * It extends BaseEntity that provides createdAt and updatedAt fields.
 */

@Entity
@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Accounts extends BaseEntity {

    @Column(name = "account_number")
    @Id
    private Long accountNumber;
    @Column(name = "customer_id")
    private Long customerId;
    @Column(name = "account_type")
    private String accountType;
    @Column(name = "branch_address")
    private String  branchAddress;
}
