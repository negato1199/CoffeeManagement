package com.coffee.coffeemanagement.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Chi_Tiet_Hoa_Don")
public class BillDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ma_CT_Hoa_Don")
    private long id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "Ma_Hoa_Don", nullable = false)
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "Ma_Thuc_Uong", nullable = false)
    private Drink drink;

    @Column(name = "So_Luong", nullable = false)
    private int count = 0;

    @Column(name = "Tong_Cong", nullable = false)
    private double price = 0d;
}
