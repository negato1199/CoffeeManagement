package com.coffee.coffeemanagement.repository;

import java.util.List;

import com.coffee.coffeemanagement.model.BillDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BillDetailRepository extends JpaRepository<BillDetail, Long> {

    @Query("SELECT d FROM BillDetail d, IN (d.bill) AS b WHERE b.id = ?1")
    List<BillDetail> getBillDetailsByBillId(long id);
}
