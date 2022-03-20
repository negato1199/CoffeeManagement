package com.coffee.coffeemanagement.controller;

import java.util.List;

import com.coffee.coffeemanagement.model.Staff;
import com.coffee.coffeemanagement.service.StaffService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/staffs")
public class StaffController {

    private StaffService staffService;

    public StaffController(StaffService staffService) {
        super();
        this.staffService = staffService;
    }

    @PostMapping
    public ResponseEntity<Staff> saveStaff(@RequestBody Staff staff) {
        return new ResponseEntity<Staff>(staffService.saveStaff(staff), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Staff> getAllStaffs() {
        return staffService.getAllStaff();
    }

    @GetMapping(params = "name")
    public List<Staff> getStaffsByName(@RequestParam String name) {
        return staffService.getStaffsByName(name);
    }

    @GetMapping(params = { "account", "password" })
    public Staff getStaffByAccountAndPassword(@RequestParam String account, @RequestParam String password) {
        return staffService.getStaffByAccountAndPassword(account, password);
    }

    @GetMapping(params = "positionId")
    public List<Staff> getStaffsByPosition(@RequestParam long positionId) {
        return staffService.getStaffsByPosition(positionId);
    }

    @GetMapping("{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable("id") long id) {
        return new ResponseEntity<Staff>(staffService.getStaffById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable("id") long id, @RequestBody Staff staff) {
        return new ResponseEntity<Staff>(staffService.updateStaff(id, staff), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStaff(@PathVariable("id") long id) {
        staffService.deleteStaff(id);
        return new ResponseEntity<String>("Staff deleted successfully.", HttpStatus.OK);
    }
}
