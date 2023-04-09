package com.coffee.coffeemanagement.service.impl;

import java.util.List;
import java.util.Objects;

import com.coffee.coffeemanagement.exception.DuplicatedException;
import com.coffee.coffeemanagement.exception.EmptyInputException;
import com.coffee.coffeemanagement.exception.ResourceNotFoundException;
import com.coffee.coffeemanagement.exception.UnauthorizedException;
import com.coffee.coffeemanagement.model.Staff;
import com.coffee.coffeemanagement.repository.StaffRepository;
import com.coffee.coffeemanagement.service.StaffService;

import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService {

    private StaffRepository staffRepository;

    public StaffServiceImpl(StaffRepository staffRepository) {
        super();
        this.staffRepository = staffRepository;
    }

    @Override
    public Staff saveStaff(Staff staff) {
        validateStaff(staff);
        checkDuplicateStaff(staff);
        return staffRepository.save(staff);
    }

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public Staff getStaffById(long id) {
        return staffRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Staff", "Id", id));
    }

    @Override
    public Staff updateStaff(long id, Staff staff) {
        validateStaff(staff);
        Staff existingStaff = getStaffById(id);
        existingStaff.setName(staff.getName());
        existingStaff.setGender(staff.getGender());
        existingStaff.setBirthDate(staff.getBirthDate());
        existingStaff.setPhoneNum(staff.getPhoneNum());
        existingStaff.setEmail(staff.getEmail());
        existingStaff.setStart(staff.getStart());
        existingStaff.setBasicSalary(staff.getBasicSalary());
        existingStaff.setPosition(staff.getPosition());
        existingStaff.setAccount(staff.getAccount());
        existingStaff.setPassword(staff.getPassword());
        staffRepository.save(existingStaff);
        return existingStaff;
    }

    @Override
    public void deleteStaff(long id) {
        getStaffById(id);
        staffRepository.deleteById(id);
    }

    @Override
    public List<Staff> getStaffsByName(String name) {
        return staffRepository.getStaffsByName(name);
    }

    @Override
    public void validateStaff(Staff staff) {
        if (Objects.isNull(staff.getName()) || staff.getName().isBlank() || Objects.isNull(staff.getGender())
                || Objects.isNull(staff.getBirthDate()) || Objects.isNull(staff.getPosition())
                || Objects.isNull(staff.getAccount()) || staff.getAccount().isBlank()
                || Objects.isNull(staff.getPassword()) || staff.getPassword().isBlank()) {
            throw new EmptyInputException("601", "Input Fields are empty");
        }

    }

    @Override
    public void checkDuplicateStaff(Staff staff) {
        Staff duplicateStaff = getStaffByAccount(staff.getAccount());
        if (Objects.nonNull(duplicateStaff))
            throw new DuplicatedException("409", "This item is already existed");
    }

    @Override
    public Staff getStaffByAccount(String account) {
        List<Staff> staffs = staffRepository.getStaffsByAccount(account);
        if (!staffs.isEmpty())
            return staffs.get(0);
        return null;
    }

    @Override
    public List<Staff> getStaffsByPosition(long positionId) {
        List<Staff> staffs = staffRepository.getStaffsByPositionId(positionId);
        if (staffs.isEmpty())
            throw new ResourceNotFoundException("Staff", "Position", positionId);
        return staffs;
    }

    @Override
    public Staff getStaffByAccountAndPassword(String account, String password) {
        List<Staff> staffs = staffRepository.getStaffsByAccountandPassword(account, password);
        if (staffs.isEmpty())
            throw new UnauthorizedException("401", "Invalid username or password!");
        return staffs.get(0);

    }
}
