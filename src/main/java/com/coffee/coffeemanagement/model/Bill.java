package com.coffee.coffeemanagement.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.coffee.coffeemanagement.model.enums.Status;

import lombok.Data;

@Data
@Entity
@Table(name = "bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "table_id", nullable = false)
    private CoffeeTable table;

    @Column(name = "creationDate", nullable = false)
    private LocalDate creationDate;

    @Column(name = "total", nullable = false)
    private double total = 0d;

    @Column(name = "status", nullable = false)
    private Status status;

}
