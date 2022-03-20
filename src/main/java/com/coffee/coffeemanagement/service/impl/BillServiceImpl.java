package com.coffee.coffeemanagement.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.coffee.coffeemanagement.exception.EmptyInputException;
import com.coffee.coffeemanagement.exception.ResourceNotFoundException;
import com.coffee.coffeemanagement.model.Bill;
import com.coffee.coffeemanagement.model.enums.Status;
import com.coffee.coffeemanagement.repository.BillRepository;
import com.coffee.coffeemanagement.service.BillService;

import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements BillService {

    private BillRepository billRepository;

    public BillServiceImpl(BillRepository billRepository) {
        super();
        this.billRepository = billRepository;
    }

    @Override
    public Bill saveBill(Bill bill) {
        validateBill(bill);
        return billRepository.save(bill);
    }

    @Override
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    @Override
    public Bill getBillById(long id) {
        return billRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bill", "Id", id));
    }

    @Override
    public Bill updateBill(long id, Bill bill) {
        validateBill(bill);
        Bill existingBill = getBillById(id);
        existingBill.setTable(bill.getTable());
        existingBill.setTotal(bill.getTotal());
        existingBill.setStatus(bill.getStatus());
        billRepository.save(existingBill);
        return existingBill;
    }

    @Override
    public void deleteBill(long id) {
        getBillById(id);
        billRepository.deleteById(id);
    }

    @Override
    public List<Bill> getBillsByCriteria(long staffId, long tableId, LocalDateTime fromDate, LocalDateTime toDate,
            Status status) {
        List<Bill> bills = billRepository.getBillsByCriteria(staffId, tableId, fromDate, toDate, status);
        return bills;
    }

    @Override
    public void validateBill(Bill bill) {
        if (Objects.isNull(bill.getStaff()) || Objects.isNull(bill.getTable())) {
            throw new EmptyInputException("601", "Input Fields are empty");
        }

    }

}
