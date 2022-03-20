package com.coffee.coffeemanagement.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.coffee.coffeemanagement.model.Bill;
import com.coffee.coffeemanagement.model.Bill_;
import com.coffee.coffeemanagement.model.CoffeeTable;
import com.coffee.coffeemanagement.model.Staff;
import com.coffee.coffeemanagement.model.Staff_;
import com.coffee.coffeemanagement.model.enums.Status;

import org.springframework.beans.factory.annotation.Autowired;

public class BillRepositoryImpl implements BillCustomRepository {

    @Autowired
    EntityManager em;

    @Override
    public List<Bill> getBillsByCriteria(long staffId, long tableId, LocalDateTime fromDate, LocalDateTime toDate,
            Status status) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Bill> cq = cb.createQuery(Bill.class);
        Root<Bill> bill = cq.from(Bill.class);
        List<Predicate> predicates = new ArrayList<>();

        if (Objects.nonNull(staffId)) {
            System.out.println("Toi da o day" + staffId);
            Join<Bill, Staff> staff = bill.join(Bill_.STAFF);
            predicates.add(cb.equal(staff.get(Staff_.ID), staffId));
        }

        if (Objects.nonNull(tableId)) {
            System.out.println("Toi da o day 1" + tableId);
            Join<Bill, CoffeeTable> table = bill.join("table");
            predicates.add(cb.equal(table.get("id"), tableId));
        }

        if (Objects.nonNull(fromDate)) {
            if (Objects.nonNull(toDate)) {
                predicates.add(cb.between(bill.get("creationDate"), fromDate, toDate));
            } else {
                predicates.add(cb.between(bill.get("creationDate"), fromDate, LocalDateTime.now()));
            }
        }

        if (Objects.nonNull(status)) {
            predicates.add(cb.equal(bill.get("status"), status));
        }
        System.out.println(predicates.toString());
        cq.where(cb.and(predicates.toArray(new Predicate[] {})));

        return em.createQuery(cq).getResultList();
    }

}
