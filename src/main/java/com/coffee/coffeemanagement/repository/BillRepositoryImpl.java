package com.coffee.coffeemanagement.repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.coffee.coffeemanagement.model.*;
import com.coffee.coffeemanagement.model.enums.Status;

import org.springframework.beans.factory.annotation.Autowired;

public class BillRepositoryImpl implements BillCustomRepository {

    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Autowired
    EntityManager em;

    @Override
    public List<Bill> getBillsByCriteria(Long staffId, Long tableId, String fromDate, String toDate,
            Status status) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Bill> cq = cb.createQuery(Bill.class);
        Root<Bill> bill = cq.from(Bill.class);
        List<Predicate> predicates = new ArrayList<>();

        if (Objects.nonNull(staffId)) {
            Join<Bill, Staff> staff = bill.join(Bill_.STAFF);
            predicates.add(cb.equal(staff.get(Staff_.ID), staffId));
        }

        if (Objects.nonNull(tableId)) {
            Join<Bill, CoffeeTable> table = bill.join(Bill_.TABLE);
            predicates.add(cb.equal(table.get(CoffeeTable_.ID), tableId));
        }

        if (Objects.nonNull(fromDate) && !fromDate.isBlank()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
            LocalDateTime from = LocalDateTime.parse(fromDate, formatter);
            if (Objects.nonNull(toDate) && !toDate.isBlank()) {
                LocalDateTime to = LocalDateTime.parse(toDate, formatter);
                predicates.add(cb.between(bill.get(Bill_.CREATION_DATE), from, to));
            } else {
                predicates.add(cb.between(bill.get(Bill_.CREATION_DATE), from, LocalDateTime.now()));
            }
        }

        if (Objects.nonNull(status)) {
            predicates.add(cb.equal(bill.get(Bill_.STATUS), status));
        }
        cq.where(cb.and(predicates.toArray(new Predicate[] {})));

        return em.createQuery(cq).getResultList();
    }

}
