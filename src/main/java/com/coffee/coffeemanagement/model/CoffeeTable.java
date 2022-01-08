package com.coffee.coffeemanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.coffee.coffeemanagement.model.enums.TableStatus;

import lombok.Data;

@Data
@Entity
@Table(name = "Coffee_table")
public class CoffeeTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "status", nullable = false)
    private TableStatus status;

    @ManyToOne
    @JoinColumn(name = "area_id", nullable = false)
    private Area area;
}
