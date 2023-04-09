package com.coffee.coffeemanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.coffee.coffeemanagement.model.enums.DrinkStage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Thuc_Uong")
@NamedQueries(value = {
        @NamedQuery(name = "Drink.getDrinkByName", query = "SELECT d FROM Drink d WHERE d.name LIKE CONCAT('%',?1,'%')")
})
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ma_Thuc_Uong")
    private long id;

    @Column(name = "Ten_Thuc_Uong", nullable = false)
    private String name;

    @Column(name = "Chu_Thich")
    private String description;

    @Column(name = "Hinh_Anh")
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "Ma_Loai")
    private Category category;

    @Column(name = "Don_Gia", nullable = false)
    private double price = 0d;
}
