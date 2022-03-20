package com.coffee.coffeemanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.coffee.coffeemanagement.model.enums.Measure;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Nguyen_Lieu")
public class Material {

    @Id
    @Column(name = "Ma_Nguyen_Lieu")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Ten_Nguyen_Lieu", nullable = false)
    private String name;

    @Column(name = "Don_Vi_Tinh", nullable = false)
    private Measure measure;

    @ManyToOne
    @JoinColumn(name = "Ma_Kho")
    private Storage storage;

    @ManyToOne
    @JoinColumn(name = "Ma_Thuc_Uong")
    private Drink drink;
}
