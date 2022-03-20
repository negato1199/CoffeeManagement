package com.coffee.coffeemanagement.service;

import java.util.List;

import com.coffee.coffeemanagement.model.Staff;

public interface StaffService {
    Staff saveStaff(Staff staff);

    List<Staff> getAllStaff();

    Staff getStaffById(long id);

    Staff updateStaff(long id, Staff staff);

    void deleteStaff(long id);

    List<Staff> getStaffsByName(String name);

    void validateStaff(Staff staff);

    void checkDuplicateStaff(Staff staff);

    Staff getStaffByAccount(String account);

    List<Staff> getStaffsByPosition(long positionId);

    Staff getStaffByAccountAndPassword(String account, String password);
}
