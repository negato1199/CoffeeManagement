package com.coffee.coffeemanagement.service;

import java.util.List;

import com.coffee.coffeemanagement.model.Bill;
import com.coffee.coffeemanagement.model.enums.Status;

public interface BillService {
    Bill saveBill(Bill bill);

    List<Bill> getAllBills();

    Bill getBillById(long id);

    Bill updateBill(long id, Bill bill);

    void updateBillTotal(long id, double amount);

    void payBill(long id);

    void deleteBill(long id);

    List<Bill> getBillsByCriteria(Long staffId, Long tableId, String fromDate, String toDate,
            Status status);

    void validateBill(Bill bill);

    boolean checkBillExist(long id);
}
