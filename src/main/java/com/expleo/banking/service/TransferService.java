package com.expleo.banking.service;

import com.expleo.banking.exception.CustomerNotFoundException;
import com.expleo.banking.exception.TransferNotFoundException;
import com.expleo.banking.model.Customer;
import com.expleo.banking.model.Transfer;
import com.expleo.banking.repository.CustomerRepository;
import com.expleo.banking.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransferService {

    @Autowired
    private TransferRepository transferRepository;

    public List<Transfer> retrieveAllTransfer() {
        return transferRepository.findAll();
    }

    public Transfer save(Transfer transfer) {

        return transferRepository.save(transfer);
    }

    public Transfer retrieveTransferById(Integer id){

        Optional<Transfer> transfer = transferRepository.findById(id);

        if (!transfer.isPresent()) {
            throw new TransferNotFoundException("transfer Not found for the given id : "+ id);
        }
        return transfer.get();
    }

    public void deleteById(Integer id) {

        transferRepository.deleteById(id);
    }

}