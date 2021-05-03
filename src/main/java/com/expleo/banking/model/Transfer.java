package com.expleo.banking.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@ApiModel("Transfer Details")
@Entity
@Getter
@Setter
public class Transfer {

    @Id
    private Integer id;

    @Column(name = "customer_id", nullable = false)
    private Integer customer_id;

    @Column(name = "beneficiary_id", nullable = false)
    private Integer beneficiary_id;

    @Column(name = "amount")
    @NotNull
    private double amount;
}
