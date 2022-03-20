package com.coffee.coffeemanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Kho")
public class Storage {

    @Id
    @Column(name = "Ma_Kho")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "So_Luong", nullable = false)
    private double quanlity;
}
