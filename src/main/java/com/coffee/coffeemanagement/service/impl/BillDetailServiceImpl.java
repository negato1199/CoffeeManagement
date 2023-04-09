package com.coffee.coffeemanagement.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.coffee.coffeemanagement.exception.EmptyInputException;
import com.coffee.coffeemanagement.exception.ResourceNotFoundException;
import com.coffee.coffeemanagement.model.Bill;
import com.coffee.coffeemanagement.model.BillDetail;
import com.coffee.coffeemanagement.model.Drink;
import com.coffee.coffeemanagement.model.enums.DrinkStage;
import com.coffee.coffeemanagement.repository.BillDetailRepository;
import com.coffee.coffeemanagement.service.BillDetailService;
import com.coffee.coffeemanagement.service.BillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillDetailServiceImpl implements BillDetailService {

    private BillDetailRepository billDetailRepository;

    @Autowired
    private BillService billService;

    public BillDetailServiceImpl(BillDetailRepository billDetailRepository) {
        super();
        this.billDetailRepository = billDetailRepository;
    }

    @Override
    public BillDetail saveBillDetail(BillDetail billDetail) {
        validateBillDetail(billDetail);
        long billId = Optional.ofNullable(billDetail).map(BillDetail::getBill).map(Bill::getId).orElse(null);
        BillDetail existingBillDetail = getBillDetailsByCriteria(billId, billDetail.getDrink().getId(),
                billDetail.getStage(), billDetail.getSize(),
                billDetail.getSugarPercentage(), billDetail.getIcePercentage()).stream().filter(Objects::nonNull)
                .findFirst().orElse(null);
        if (Objects.isNull(existingBillDetail)) {
            billDetail.setCount(1);
            BillDetail savedBillDetail = billDetailRepository.save(billDetail);
            double amount = Optional.ofNullable(billDetail).map(BillDetail::getDrink).map(Drink::getPrice).orElse(0d);
            billService.updateBillTotal(billId, amount);
            return savedBillDetail;
        }
        return increaseCount(existingBillDetail);
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
        existingBillDetail.setStage(billDetail.getStage());
        existingBillDetail.setSize(billDetail.getSize());
        existingBillDetail.setSugarPercentage(billDetail.getSugarPercentage());
        existingBillDetail.setIcePercentage(billDetail.getIcePercentage());
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

    @Override
    public List<BillDetail> getBillDetailsByCriteria(Long billId, Long drinkId, DrinkStage stage, String size,
            Integer sugarPercentage, Integer icePercentage) {
        return billDetailRepository.getBillDetailsByCriteria(billId, drinkId, stage, size, sugarPercentage,
                icePercentage).orElseGet(ArrayList::new);
    }

    private BillDetail increaseCount(BillDetail billDetail) {
        billDetail.setCount(billDetail.getCount() + 1);
        billDetailRepository.save(billDetail);
        double amount = Optional.ofNullable(billDetail).map(BillDetail::getDrink).map(Drink::getPrice).orElse(0d);
        billService.updateBillTotal(billDetail.getBill().getId(), amount);
        return billDetail;
    }
}
