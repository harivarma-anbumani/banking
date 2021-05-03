package com.expleo.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.expleo.banking.model.Beneficiary;

@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Integer> {

    @Query(value = "SELECT * FROM beneficiary WHERE id=? ", nativeQuery = true )
    Beneficiary find(Integer id);
}