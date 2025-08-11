package com.eazybytes.accounts.repository;

import com.eazybytes.accounts.entity.Accounts;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * This is a Spring Data JPA repository for the Accounts entity.
 * It extends JpaRepository interface which provides methods to interact with the database.
 * The JpaRepository interface is a generic interface that requires two type parameters: the type of the entity managed by the repository,
 * and the type of the ID of the entity. In this case, the type of the entity is Accounts and the type of the ID is Long.
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
public interface AccountsRepository extends JpaRepository<Accounts, Long> {

    Optional<Accounts> findByCustomerId(Long customerId);
    /**
     * The @Transactional annotation is used to specify that a method should be
     * executed in a transaction. If the method executes successfully, the
     * transaction is committed. If the method throws an exception, the
     * transaction is rolled back.
     * <p>
     * The @Modifying annotation is used to specify that a method should modify
     * the database. If the method is annotated with @Modifying, then the
     * database should be modified. If the method is not annotated with
     * @Modifying, then the database should not be modified.
     * <p>
     * In this case, the deleteAccount method is annotated with @Transactional,
     * which means that the method should be executed in a transaction. The
     * @Modifying annotation is used to specify that the method should modify the
     * database. If the method is successful, the transaction is committed. If
     * the method throws an exception, the transaction is rolled back.
     */
    @Transactional
    @Modifying
    void deleteByCustomerId(Long customerId);

}
