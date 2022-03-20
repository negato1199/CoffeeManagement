package com.coffee.coffeemanagement.service;

import java.util.List;

import com.coffee.coffeemanagement.model.BillDetail;

public interface BillDetailService {
    BillDetail saveBillDetail(BillDetail billDetail);

    List<BillDetail> getAllBillDetails();

    BillDetail getBillDetailById(long id);

    BillDetail updateBillDetail(long id, BillDetail billDetail);

    List<BillDetail> getBillDetailByBillId(long billId);

    void deleteBillDetail(long id);

    void validateBillDetail(BillDetail billDetail);
}
