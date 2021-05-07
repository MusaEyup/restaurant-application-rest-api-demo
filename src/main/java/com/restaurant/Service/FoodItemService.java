package com.restaurant.Service;

import com.restaurant.Context.ItemContext;
import com.restaurant.Entity.Category;
import com.restaurant.Entity.FoodItem;

import java.util.List;

public interface FoodItemService {

    List<FoodItem> getAllFoodItems();
    List<FoodItem> getFoodItemsByCategory(Long categoryId);
    FoodItem getOne(Long id);
    Long addFoodItem(ItemContext itemContext);
    Long updateFoodItem(ItemContext itemContext);
    Long updateFoodItemDetails(ItemContext itemContext);
    //Long updateFoodItemImage(ItemContext itemContext);
    Long deleteFoodItem(Long id);
    Category getCategoryByItemId(Long id);

    List<FoodItem> getAllFoodItemsByName(String name);
}
