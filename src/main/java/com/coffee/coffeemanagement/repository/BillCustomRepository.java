package com.coffee.coffeemanagement.repository;

import java.util.List;

import com.coffee.coffeemanagement.model.Bill;
import com.coffee.coffeemanagement.model.enums.Status;

public interface BillCustomRepository {
    List<Bill> getBillsByCriteria(Long staffId, Long tableId, String fromDate, String toDate,
            Status status);
}
