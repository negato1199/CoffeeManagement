package com.coffee.coffeemanagement.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.coffee.coffeemanagement.model.enums.Status;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Hoa_Don")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ma_Hoa_Don")
    private long id;

    @ManyToOne
    @JoinColumn(name = "Ma_Nhan_Vien")
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "Ma_Ban")
    private CoffeeTable table;

    @Column(name = "Ngay_Lap", columnDefinition = "DATETIME")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime creationDate = LocalDateTime.now();

    @Column(name = "Tong_Cong", nullable = false)
    private double total = 0d;

    @Column(name = "Trang_Thai", nullable = false)
    private Status status = Status.NOT_PAID;

}
