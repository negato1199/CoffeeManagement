package com.coffee.coffeemanagement.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.coffee.coffeemanagement.model.converter.GenderConverter;
import com.coffee.coffeemanagement.model.enums.Gender;

import lombok.Data;

@Data
@Entity
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "gender", nullable = false)
    @Convert(converter = GenderConverter.class)
    private Gender gender;

    @Column(name = "birthDate", nullable = false)
    private LocalDate birthDate;

    @Column(name = "phoneNum")
    private String phoneNum;

    @Column(name = "email")
    private String email;

    @Column(name = "start", nullable = false)
    private LocalDate start;

    @Column(name = "basicSalary", nullable = false)
    private double basicSalary = 0d;

    @ManyToOne
    @JoinColumn(name = "position_Id", nullable = false)
    private Position position;

    @OneToOne
    @JoinColumn(name = "account_Id", nullable = false)
    private Account account;
}
