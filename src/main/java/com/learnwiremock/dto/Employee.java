package com.learnwiremock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee implements Serializable{

    private static final long serialVersionUID = 1L;

    protected int matriculeId;

    protected String lastname;

    protected String firstname;

    protected String dateOfBirth;

    private String employmentType;

    private String email;

    private String startDate;

    protected BigDecimal salaire;

    protected Address address;


}
