package com.coffee.coffeemanagement.service.impl;

import java.util.List;
import java.util.Objects;

import com.coffee.coffeemanagement.exception.EmptyInputException;
import com.coffee.coffeemanagement.exception.ResourceNotFoundException;
import com.coffee.coffeemanagement.model.BillDetail;
import com.coffee.coffeemanagement.repository.BillDetailRepository;
import com.coffee.coffeemanagement.service.BillDetailService;

import org.springframework.stereotype.Service;

@Service
public class BillDetailImpl implements BillDetailService {

    private BillDetailRepository billDetailRepository;

    public BillDetailImpl(BillDetailRepository billDetailRepository) {
        super();
        this.billDetailRepository = billDetailRepository;
    }

    @Override
    public BillDetail saveBillDetail(BillDetail billDetail) {
        validateBillDetail(billDetail);
        return billDetailRepository.save(billDetail);
    }

    @Override
    public List<BillDetail> getAllBillDetails() {
        return billDetailRepository.findAll();
    }

    @Override
    public BillDetail getBillDetailById(long id) {
        return billDetailRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BillDetail", "Id", id));
    }

    @Override
    public BillDetail updateBillDetail(long id, BillDetail billDetail) {
        validateBillDetail(billDetail);
        BillDetail existingBillDetail = getBillDetailById(id);
        existingBillDetail.setBill(billDetail.getBill());
        existingBillDetail.setDrink(billDetail.getDrink());
        existingBillDetail.setCount(billDetail.getCount());
        existingBillDetail.setPrice(billDetail.getPrice());
        billDetailRepository.save(existingBillDetail);
        return existingBillDetail;
    }

    @Override
    public List<BillDetail> getBillDetailByBillId(long billId) {
        return billDetailRepository.getBillDetailsByBillId(billId);
    }

    @Override
    public void deleteBillDetail(long id) {
        getBillDetailById(id);
        billDetailRepository.deleteById(id);
    }

    @Override
    public void validateBillDetail(BillDetail billDetail) {
        if (Objects.isNull(billDetail.getBill()) || Objects.isNull(billDetail.getDrink()))
            throw new EmptyInputException("601", "Input Fields are empty");
    }

}
