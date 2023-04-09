package com.coffee.coffeemanagement.repository.custom;

import java.util.List;
import java.util.Optional;

import com.coffee.coffeemanagement.model.BillDetail;
import com.coffee.coffeemanagement.model.enums.DrinkStage;

public interface BillDetailCustomRepository {

    Optional<List<BillDetail>> getBillDetailsByCriteria(Long billId, Long drinkId, DrinkStage stage, String size,
            Integer sugarPercentage, Integer icePercentage);

}
