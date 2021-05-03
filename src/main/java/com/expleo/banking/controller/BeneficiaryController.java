package com.expleo.banking.controller;

import com.expleo.banking.model.Beneficiary;
import com.expleo.banking.service.BeneficiaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@Slf4j
@RestController
@RequestMapping(path = "/api")
public class BeneficiaryController {

    @Autowired
    private BeneficiaryService beneficiaryService;

    @GetMapping(path = "/beneficiaries")
    public List<Beneficiary> retrieveAllBeneficiaries()
    {
        return beneficiaryService.retrieveAllBeneficiary();    }

    @GetMapping(path = "/beneficiary/{beneficiaryId}")
    public ResponseEntity<Beneficiary> retrieveBeneficiary(@PathVariable Integer beneficiaryId) {
        log.info("Retrieve info for a Beneficiary : {} ", beneficiaryId );
        return new ResponseEntity<Beneficiary>( beneficiaryService.retrieveBeneficiaryById( beneficiaryId ) , HttpStatus.OK);
    }

    @PostMapping(path = "/beneficiary")
    public ResponseEntity<Object> save(@RequestBody Beneficiary beneficiary) {
        Beneficiary savedBeneficiary = beneficiaryService.save(beneficiary);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedBeneficiary.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/beneficiary/{id}")
    public void deleteBeneficiary(@PathVariable Integer id) {
        beneficiaryService.deleteById(id);
    }
}
