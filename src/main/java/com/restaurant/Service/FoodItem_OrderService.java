package com.restaurant.Service;

import com.restaurant.Context.FoodOrderContext;
import com.restaurant.Context.ItemContext;
import com.restaurant.Entity.FoodItem_Order;

import java.util.List;

public interface FoodItem_OrderService {

    List<FoodItem_Order> getAllFoodItem_Order();

    Long addFoodItem_Order(FoodOrderContext foodOrderContext);
    Long deleteFoodItem_Order (Long id);
    Long addFoodItem_OrderList(FoodOrderContext foodOrderContext);
    Long updateFoodItem_Order(Long foodItemOrderId, FoodOrderContext foodOrderContext);

}
