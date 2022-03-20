package com.coffee.coffeemanagement.repository;

import java.util.List;

import com.coffee.coffeemanagement.model.Position;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PositionRepository extends JpaRepository<Position, Long> {

    @Query("SELECT p FROM Position p WHERE p.name LIKE CONCAT('%',?1,'%')")
    List<Position> getPositionsByName(String name);
}
