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
@Table(name = "Chuc_Vu")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ma_Chuc_Vu")
    private long id;

    @Column(name = "Ten_Chuc_Vu", nullable = false)
    private String name;

    @Column(name = "He_So_Luong", nullable = false)
    private int coefficient = 1;

}
