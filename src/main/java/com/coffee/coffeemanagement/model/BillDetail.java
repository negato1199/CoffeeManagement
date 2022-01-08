package com.coffee.coffeemanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "bill_detail")
public class BillDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "bill_Id", nullable = false)
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "drink_Id", nullable = false)
    private Drink drink;

    @Column(name = "count", nullable = false)
    private int count = 0;

    @Column(name = "price", nullable = false)
    private double price = 0d;
}
