package com.coffee.coffeemanagement.controller;

import java.util.List;

import com.coffee.coffeemanagement.model.BillDetail;
import com.coffee.coffeemanagement.service.BillDetailService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/billDetails")
public class BillDetailController {

    private BillDetailService billDetailService;

    public BillDetailController(BillDetailService billDetailService) {
        super();
        this.billDetailService = billDetailService;
    }

    @PostMapping
    public ResponseEntity<BillDetail> saveBillDetail(@RequestBody BillDetail billDetail) {
        return new ResponseEntity<BillDetail>(billDetailService.saveBillDetail(billDetail), HttpStatus.CREATED);
    }

    @GetMapping
    public List<BillDetail> getAllBillDetails() {
        return billDetailService.getAllBillDetails();
    }

    @GetMapping(params = "billId")
    public List<BillDetail> getBillDetailsByBillId(@RequestParam long billId) {
        return billDetailService.getBillDetailByBillId(billId);
    }

    @GetMapping("{id}")
    public ResponseEntity<BillDetail> getBillDetailById(@PathVariable("id") long id) {
        return new ResponseEntity<BillDetail>(billDetailService.getBillDetailById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<BillDetail> updateStaff(@PathVariable("id") long id, @RequestBody BillDetail billDetail) {
        return new ResponseEntity<BillDetail>(billDetailService.updateBillDetail(id, billDetail), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStaff(@PathVariable("id") long id) {
        billDetailService.deleteBillDetail(id);
        return new ResponseEntity<String>("BillDetail deleted successfully.", HttpStatus.OK);
    }
}
