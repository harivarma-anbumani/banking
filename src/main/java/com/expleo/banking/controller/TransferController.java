package com.expleo.banking.controller;

import com.expleo.banking.model.Customer;
import com.expleo.banking.model.Transfer;
import com.expleo.banking.service.CustomerService;
import com.expleo.banking.service.TransferService;
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
public class TransferController {

    @Autowired
    private TransferService transferService;

    @GetMapping(path = "/transfers")
    public List<Transfer> retrieveAllTransfers()
    {
        return transferService.retrieveAllTransfer();
    }

    @GetMapping(path = "/transfer/{transferId}")
    public ResponseEntity<Transfer> retrieveTransfer(@PathVariable Integer transferId) {
        log.info("Retrieve info for a Transfer : {} ", transferId );
        return new ResponseEntity<Transfer>( transferService.retrieveTransferById( transferId ) , HttpStatus.OK);
    }

    @PostMapping(path = "/transfer")
    public ResponseEntity<Object> save(@RequestBody Transfer transfer) {
        Transfer savedTransfer = transferService.save(transfer);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedTransfer.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/transfer/{id}")
    public void deleteTransfer(@PathVariable Integer id) {
        transferService.deleteById(id);
    }
}
