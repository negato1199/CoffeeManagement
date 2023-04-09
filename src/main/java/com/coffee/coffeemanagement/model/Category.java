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
@Table(name = "Loai_Thuc_Uong")
@NamedQueries(value = {
        @NamedQuery(name = "Category.getCategoryByName", query = "SELECT c FROM Category c WHERE c.name LIKE CONCAT('%',?1,'%')")
})
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ma_Loai")
    private long id;

    @Column(name = "Ten_Loai", nullable = false)
    private String name;

    @Column(name = "Hinh_Anh")
    private String imgUrl;
}
