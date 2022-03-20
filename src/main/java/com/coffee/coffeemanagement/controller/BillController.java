package com.coffee.coffeemanagement.controller;

import java.time.LocalDateTime;
import java.util.List;

import com.coffee.coffeemanagement.model.Bill;
import com.coffee.coffeemanagement.model.enums.Status;
import com.coffee.coffeemanagement.service.BillService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Bill> getAllBills() {
        return billService.getAllBills();
    }

    @GetMapping(params = { "staffId", "tableId", "fromDate", "toDate", "status" })
    public List<Bill> getBillsByAccountAndPassword(@RequestParam long staffId, @RequestParam long tableId,
            @RequestParam LocalDateTime fromDate, @RequestParam LocalDateTime toDate, @RequestParam Status status) {
        return billService.getBillsByCriteria(staffId, tableId, fromDate, toDate, status);
    }

    @GetMapping("{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable("id") long id) {
        return new ResponseEntity<Bill>(billService.getBillById(id), HttpStatus.OK);
    }
}
