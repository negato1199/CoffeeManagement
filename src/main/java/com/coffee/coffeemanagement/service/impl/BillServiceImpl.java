package com.coffee.coffeemanagement.service.impl;

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

    public void payBill(long id) {
        Bill existingBill = getBillById(id);
        existingBill.setStatus(Status.PAID);
        billRepository.save(existingBill);
    }

    @Override
    public void deleteBill(long id) {
        getBillById(id);
        billRepository.deleteById(id);
    }

    @Override
    public List<Bill> getBillsByCriteria(Long staffId, Long tableId, String fromDate, String toDate,
            Status status) {
        return billRepository.getBillsByCriteria(staffId, tableId, fromDate, toDate, status);
    }

    @Override
    public void validateBill(Bill bill) {
        if (Objects.isNull(bill.getStaff())) {
            throw new EmptyInputException("601", "Input Fields are empty");
        }

    }

    @Override
    public boolean checkBillExist(long id) {
        return billRepository.existsById(id);
    }

    @Override
    public void updateBillTotal(long id, double amount) {
        Bill existingBill = getBillById(id);
        double total = existingBill.getTotal();
        existingBill.setTotal(total + amount);
        billRepository.save(existingBill);
    }

}
