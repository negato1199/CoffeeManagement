package com.coffee.coffeemanagement.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import com.coffee.coffeemanagement.model.Bill;
import com.coffee.coffeemanagement.model.BillDetail;
import com.coffee.coffeemanagement.model.BillDetail_;
import com.coffee.coffeemanagement.model.Bill_;
import com.coffee.coffeemanagement.model.Drink;
import com.coffee.coffeemanagement.model.Drink_;
import com.coffee.coffeemanagement.model.enums.DrinkStage;
import com.coffee.coffeemanagement.repository.custom.BillDetailCustomRepository;

public class BillDetailRepositoryImpl implements BillDetailCustomRepository {

    @Autowired
    EntityManager em;

    @Override
    public Optional<List<BillDetail>> getBillDetailsByCriteria(Long billId, Long drinkId, DrinkStage stage, String size,
            Integer sugarPercentage, Integer icePercentage) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<BillDetail> cq = cb.createQuery(BillDetail.class);
        Root<BillDetail> billDetail = cq.from(BillDetail.class);
        List<Predicate> predicates = new ArrayList<>();

        if (Objects.nonNull(billId)) {
            Join<BillDetail, Bill> bill = billDetail.join(BillDetail_.BILL);
            predicates.add(cb.equal(bill.get(Bill_.ID), billId));
        }

        if (Objects.nonNull(drinkId)) {
            Join<BillDetail, Drink> drink = billDetail.join(BillDetail_.DRINK);
            predicates.add(cb.equal(drink.get(Drink_.ID), drinkId));
        }

        if (Objects.nonNull(stage)) {
            predicates.add(cb.equal(billDetail.get(BillDetail_.STAGE), stage));
        }

        if (Objects.nonNull(size)) {
            predicates.add(cb.equal(billDetail.get(BillDetail_.SIZE), size));
        }

        if (Objects.nonNull(sugarPercentage)) {
            predicates.add(cb.equal(billDetail.get(BillDetail_.SUGAR_PERCENTAGE), sugarPercentage));
        }

        if (Objects.nonNull(icePercentage)) {
            predicates.add(cb.equal(billDetail.get(BillDetail_.ICE_PERCENTAGE), icePercentage));
        }

        cq.where(cb.and(predicates.toArray(new Predicate[] {})));

        return Optional.ofNullable(em.createQuery(cq).getResultList());
    }

}
