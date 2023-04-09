package com.coffee.coffeemanagement.service;

import java.util.List;

import com.coffee.coffeemanagement.model.BillDetail;
import com.coffee.coffeemanagement.model.enums.DrinkStage;

public interface BillDetailService {
    BillDetail saveBillDetail(BillDetail billDetail);

    List<BillDetail> getAllBillDetails();

    BillDetail getBillDetailById(long id);

    BillDetail updateBillDetail(long id, BillDetail billDetail);

    List<BillDetail> getBillDetailByBillId(long billId);

    List<BillDetail> getBillDetailsByCriteria(Long billId, Long drinkId, DrinkStage stage, String size,
            Integer sugarPercentage, Integer icePercentage);

    void deleteBillDetail(long id);

    void validateBillDetail(BillDetail billDetail);
}
