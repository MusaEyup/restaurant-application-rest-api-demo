package com.restaurant.Service;

import com.restaurant.Context.FoodItemContext;
import com.restaurant.Context.FoodItem_PortionContext;
import com.restaurant.Entity.FoodItem_Portion;
import com.restaurant.Entity.Portion;

import java.util.List;

public interface FoodItem_PortionService {
    FoodItem_Portion getById(Long id);
    List<FoodItem_Portion> getByFoodItemName(String foodName);
    List<FoodItem_Portion> getByFoodItemId(Long id);
    List<Portion> getPortionByFoodItemId(Long id);
    List<FoodItem_Portion> getAll();
    List<Long> addFoodItemsPortions(FoodItemContext foodItemContext);

    List<Long> updateFoodItemPortions(List<FoodItem_PortionContext> contexts);

    Long deleteFoodItemPortionById(Long id);
}
