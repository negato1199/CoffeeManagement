package com.coffee.coffeemanagement.model;

import java.time.LocalDate;
import java.time.LocalTime;

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
@Table(name = "Ca_Truc")
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ma_Ca_Truc")
    private long id;

    @Column(name = "Ten_Ca_Truc", nullable = false)
    private String name;

    @Column(name = "Ngay_Truc", nullable = false)
    private LocalDate date;

    @Column(name = "Gio_Bat_Dau", nullable = false)
    private LocalTime from;

    @Column(name = "Gio_Ket_Thuc", nullable = false)
    private LocalTime to;

}
