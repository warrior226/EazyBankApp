package com.eazybytes.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * This class is a base entity for all other entities in the application.
 * It provides createdAt and updatedAt fields, which are automatically populated by JPA.
 * The createdAt field is set when the entity is first created and never updated.
 * The updatedAt field is automatically updated every time the entity is updated.
 * <p>
 * The @{@link MappedSuperclass} annotation indicates that this class is a mapped superclass.
 * It is not an entity itself, but rather a class that can be extended by entities.
 * <p>
 * The @{@link Getter} and @{@link Setter} annotations are Lombok annotations that automatically generate getter and setter methods for the fields.
 * <p>
 * The @{@link ToString} annotation is a Lombok annotation that automatically generates a {@code toString()} method for the class.
 * <p>
 */
@MappedSuperclass
@Getter@Setter@ToString
public class BaseEntity {

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_by", nullable = false, updatable = false)
    private String createdBy;

    @Column(name = "updated_by",insertable = false)
    private String updatedBy;
}
