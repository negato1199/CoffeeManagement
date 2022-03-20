package com.coffee.coffeemanagement.repository;

import com.coffee.coffeemanagement.model.Bill;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long>, BillCustomRepository {

}
