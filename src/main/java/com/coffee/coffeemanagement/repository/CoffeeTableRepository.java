package com.coffee.coffeemanagement.repository;

import java.util.List;

import com.coffee.coffeemanagement.model.CoffeeTable;
import com.coffee.coffeemanagement.model.enums.TableStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CoffeeTableRepository extends JpaRepository<CoffeeTable, Long> {

    @Query("SELECT c FROM CoffeeTable c, IN (c.area) AS a WHERE a.id = ?1")
    List<CoffeeTable> getCoffeeTablesByArea(long areaId);

    @Query("SELECT c FROM CoffeeTable c WHERE c.status = ?1")
    List<CoffeeTable> getCoffeeTablesByStatus(TableStatus status);
}
