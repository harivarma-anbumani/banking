package com.expleo.banking.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@ApiModel("Account Holders details in a Bank")
@Entity
@Getter
@Setter
public class Customer {

    @Id
    private Integer id;

    @Size(min=3, max = 255, message="Name should have atleast 3 characters and max 255 characters")
    @ApiModelProperty(notes="Name should have atleast 3 characters & maximum 255 characters")
    @NotNull
    private String name;

    @Column(name = "balance")
    @NotNull
    private double balance;

}
