package com.coffee.coffeemanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "permission_detail")
public class PermissionDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "permission_id", nullable = false)
    private Permission permission;

    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false)
    private Position position;
}
