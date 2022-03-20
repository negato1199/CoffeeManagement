package com.coffee.coffeemanagement.repository;

import java.util.List;

import com.coffee.coffeemanagement.model.Staff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StaffRepository extends JpaRepository<Staff, Long> {

    @Query("SELECT s FROM Staff s WHERE s.name LIKE CONCAT('%',?1,'%')")
    List<Staff> getStaffsByName(String name);

    @Query("SELECT s FROM Staff s WHERE s.account = ?1")
    List<Staff> getStaffsByAccount(String account);

    @Query("SELECT s FROM Staff s, IN (s.position) AS p WHERE p.id = ?1")
    List<Staff> getStaffsByPositionId(long positionId);

    @Query("SELECT s FROM Staff s WHERE s.account = ?1 AND s.password = ?2")
    List<Staff> getStaffsByAccountandPassword(String account, String password);
}
