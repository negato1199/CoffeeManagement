package com.coffee.coffeemanagement.service;

import java.time.LocalDateTime;
import java.util.List;

import com.coffee.coffeemanagement.model.Bill;
import com.coffee.coffeemanagement.model.enums.Status;

public interface BillService {
    Bill saveBill(Bill bill);

    List<Bill> getAllBills();

    Bill getBillById(long id);

    Bill updateBill(long id, Bill bill);

    void deleteBill(long id);

    List<Bill> getBillsByCriteria(long staffId, long tableId, LocalDateTime fromDate, LocalDateTime toDate,
            Status status);

    void validateBill(Bill bill);
}
