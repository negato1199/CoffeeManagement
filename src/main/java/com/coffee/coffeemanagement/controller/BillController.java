package com.coffee.coffeemanagement.controller;

import java.util.List;

import com.coffee.coffeemanagement.model.Bill;
import com.coffee.coffeemanagement.model.enums.Status;
import com.coffee.coffeemanagement.service.BillService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/bills")
public class BillController {

    private BillService billService;

    public BillController(BillService billService) {
        super();
        this.billService = billService;
    }

    @PostMapping
    public ResponseEntity<Bill> saveBill(@RequestBody Bill bill) {
        return new ResponseEntity<Bill>(billService.saveBill(bill), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Bill> getBillsByByCriteria(@RequestParam(required = false) Long staffId,
            @RequestParam(required = false) Long tableId, @RequestParam(required = false) String fromDate,
            @RequestParam(required = false) String toDate, @RequestParam(required = false) Status status) {
        return billService.getBillsByCriteria(staffId, tableId, fromDate, toDate, status);
    }

    @GetMapping("{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable("id") long id) {
        return new ResponseEntity<Bill>(billService.getBillById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Bill> updateBill(@PathVariable("id") long id, @RequestBody Bill bill) {
        return new ResponseEntity<Bill>(billService.updateBill(id, bill), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBill(@PathVariable("id") long id) {
        billService.deleteBill(id);
        return new ResponseEntity<String>("Bill deleted successfully.", HttpStatus.OK);
    }
}
