package com.coffee.coffeemanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Khu_Vuc")
@NamedQueries(value = {
        @NamedQuery(name = "Area.getAreaByName", query = "SELECT a FROM Area a WHERE a.name LIKE CONCAT('%',?1,'%')")
})
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ma_Khu_Vuc")
    private long id;

    @Column(name = "Ten_Khu_Vuc", nullable = false)
    private String name;
}
