package com.coffee.coffeemanagement.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.coffee.coffeemanagement.model.Bill;
import com.coffee.coffeemanagement.model.enums.Status;

public interface BillCustomRepository {
    List<Bill> getBillsByCriteria(long staffId, long tableId, LocalDateTime fromDate, LocalDateTime toDate,
            Status status);
}
