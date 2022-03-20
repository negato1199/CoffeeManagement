package com.coffee.coffeemanagement.repository;

import java.util.List;

import com.coffee.coffeemanagement.model.Area;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<Area, Long> {

    List<Area> getAreaByName(String name);
}
