package com.expleo.banking.service;

import com.expleo.banking.exception.BeneficiaryNotFoundException;
import com.expleo.banking.model.Beneficiary;
import com.expleo.banking.repository.BeneficiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiaryService {

    @Autowired
    private BeneficiaryRepository beneficiaryRepository;

    public List<Beneficiary> retrieveAllBeneficiary() {
        return beneficiaryRepository.findAll();
    }

    public Beneficiary save(Beneficiary beneficiary) {

        return beneficiaryRepository.save(beneficiary);
    }

    public Beneficiary retrieveBeneficiaryById(Integer id){

        Beneficiary beneficiary = beneficiaryRepository.find(id);

        if ( beneficiary == null ) {
            throw new BeneficiaryNotFoundException(String.format("Beneficiary Not found for the given id : %s", id ) );
        }
        return beneficiary;
    }

    public void deleteById(Integer id) {

        beneficiaryRepository.deleteById(id);
    }

}