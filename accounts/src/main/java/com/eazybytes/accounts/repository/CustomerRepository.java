package com.eazybytes.accounts.repository;

import com.eazybytes.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * This is a Spring Data JPA repository for the Customer entity.
 * It extends JpaRepository interface which provides methods to interact with the database.
 * The JpaRepository interface is a generic interface that requires two type parameters: the type of the entity managed by the repository,
 * and the type of the ID of the entity. In this case, the type of the entity is Customer and the type of the ID is Long.
 * The JpaRepository interface is annotated with @NoRepositoryBean which means that Spring Data JPA will not create a Spring bean for this
 * interface. Instead, it will create a Spring bean for each interface that extends JpaRepository.
 * The @Repository annotation is used to mark this interface as a Spring Data JPA repository.
 * The purpose of this interface is to provide methods to interact with the database and perform CRUD operations.
 * The methods that are provided by JpaRepository are:
 * - findAll(): returns a list of all the entities in the database.
 * - findById(ID id): returns the entity with the given ID.
 * - save(S entity): saves the given entity in the database.
 * - deleteById(ID id): deletes the entity with the given ID.
 * - delete(S entity): deletes the given entity.
 * - deleteAll(): deletes all the entities in the database.
 * - count(): returns the number of entities in the database.
 * - existsById(ID id): returns true if an entity with the given ID exists in the database.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * This method is a custom query that returns a customer by its mobile number.
     * The method name is findByMobileNumber and it takes a String parameter which is the mobile number.
     * The method returns an Optional of Customer which is a container that may or may not contain a non-null value.
     * If the customer is found, the Optional will contain the customer. If the customer is not found, the Optional will be empty.
     * The @Query annotation is used to specify the query that should be executed.
     * The query is a JPQL (Java Persistence Query Language) query that selects the customer from the customer table
     * where the mobile number is equal to the given mobile number.
     */
    Optional<Customer> findByMobileNumber(String mobileNumber);
}
