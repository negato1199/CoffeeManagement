package com.coffee.coffeemanagement.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.coffee.coffeemanagement.model.converter.GenderConverter;
import com.coffee.coffeemanagement.model.enums.Gender;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Nhan_Vien")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ma_Nhan_Vien")
    private long id;

    @Column(name = "Ten_Nhan_Vien", nullable = false)
    private String name;

    @Column(name = "Gioi_Tinh", nullable = false)
    @Convert(converter = GenderConverter.class)
    private Gender gender;

    @Column(name = "Ngay_Sinh", nullable = false, columnDefinition = "DATE")
    private LocalDate birthDate;

    @Column(name = "So_DT")
    private String phoneNum;

    @Column(name = "Email")
    private String email;

    @Column(name = "Ngay_Bat_Dau", nullable = false, columnDefinition = "DATE")
    private LocalDate start = LocalDate.now();

    @Column(name = "Luong", nullable = false)
    private double basicSalary = 0d;

    @ManyToOne
    @JoinColumn(name = "Ma_Chuc_Vu", nullable = false)
    private Position position;

    @Column(name = "Tai_khoan", nullable = false, unique = true)
    private String account;

    @Column(name = "Mat_khau", nullable = false)
    private String password;

    @Column(name = "Hinh_anh")
    private String imgUrl;
}
