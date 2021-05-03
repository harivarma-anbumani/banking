package com.expleo.banking.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.persistence.Entity;
import javax.persistence.Id;


@ApiModel("Beneficiary Details")
@Entity
@Getter
@Setter
public class Beneficiary {

    @Id
    private Integer id;

    @Size(min = 3, max = 255, message = "Name should have atleast 3 characters and max 255 characters")
    @ApiModelProperty(notes = "Name should have atleast 3 characters & maximum 255 characters")
    @NotNull
    private String name;

}
