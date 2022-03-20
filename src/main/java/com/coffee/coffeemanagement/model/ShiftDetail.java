package com.coffee.coffeemanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.coffee.coffeemanagement.model.enums.ShiftStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Chi_Tiet_Ca_Truc")
public class ShiftDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ma_CT_Ca_Truc")
    private long id;

    @ManyToOne
    @JoinColumn(name = "Ma_Ca_Truc", nullable = false)
    private Shift shift;

    @ManyToOne
    @JoinColumn(name = "Ma_Nhan_Vien", nullable = false)
    private Staff staff;

    @Column(name = "Trang_Thai", nullable = false)
    private ShiftStatus status;
}
