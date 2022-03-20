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
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Ban")
public class CoffeeTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ma_Ban")
    private long id;

    @Column(name = "Trang_Thai")
    private TableStatus status = TableStatus.EMPTY;

    @ManyToOne
    @JoinColumn(name = "Ma_Khu_Vuc")
    private Area area;
}
