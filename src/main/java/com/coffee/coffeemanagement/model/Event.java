package com.coffee.coffeemanagement.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Su_Kien")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ma_Su_Kien")
    private long id;

    @Column(name = "Ten_Su_Kien", nullable = false)
    private String name;

    @Column(name = "Ngay_Bat_Dau", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate from;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "Ngay_Ket_Thuc", nullable = false)
    private LocalDate to;

    @Column(name = "Giam_Gia", nullable = false)
    private int discount = 0;
}
