package com.eazybytes.loans.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    /**
     * @CreatedDate is an annotation provided by the Spring framework.
     * It is used to mark a field as a date when the entity was created.
     * The @Column annotation is used to specify the database column name and other properties.
     * The name property specifies the name of the column.
     * The nullable property specifies whether the column can contain null values (false).
     * The updatable property specifies whether the column can be updated (false).
     */
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;


    /**
     * @LastModifiedDate is an annotation provided by the Spring framework.
     * It is used to mark a field as a date when the entity was last updated.
     * The @Column annotation is used to specify the database column name and other properties.
     * The name property specifies the name of the column.
     * The insertable property specifies whether the column can be inserted (false).
     */
    @LastModifiedDate
    @Column(name = "updated_at", insertable = false)
    private LocalDateTime updatedAt;

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    private String createdBy;

    @LastModifiedBy
    @Column(name = "updated_by", insertable = false)
    private String updatedBy;
}
