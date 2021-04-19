package com.restaurant.Service.Impl;

import com.restaurant.Context.ItemContext;
import com.restaurant.Entity.Category;
import com.restaurant.Entity.FoodItem;
import com.restaurant.Entity.FoodItem_Portion;
import com.restaurant.Repository.CategoryRepository;
import com.restaurant.Repository.FoodItemRepository;
import com.restaurant.Repository.FoodItem_PortionRepository;
import com.restaurant.Service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FoodItemServiceImpl implements FoodItemService {

    @Autowired
    FoodItemRepository itemRepo;

    @Autowired
    private FoodItem_PortionRepository foodItemPortion;
    @Autowired
    private CategoryRepository categoryRepo;

    @Override
    public List<FoodItem> getAllFoodItems() {
        return itemRepo.findAll();
    }

    @Override
    public List<FoodItem> getFoodItemsByCategory(Long categoryId) {
        return itemRepo.findAllByCategory(categoryId);
    }

    @Override
    public FoodItem getOne(Long id) {
        return itemRepo.findFoodItemById(id);
    }

    @Override
    @Transactional
    public Long addFoodItem(ItemContext itemContext) {
        FoodItem_Portion fo = foodItemPortion.findFoodItem_PortionById(itemContext.getFoodItemPortionId());
        Category category = categoryRepo.findCategoryById(itemContext.getCategoryId());
        FoodItem foodItem = new FoodItem(
                fo.getFoodItem().getItemName(),
                itemContext.getQuantity(),
                category
        );
        itemRepo.save(foodItem);
        return foodItem.getId();
    }

    @Override
    @Transactional
    public Long updateFoodItem(ItemContext itemContext) {
        FoodItem foodItem = itemRepo.findFoodItemById(itemContext.getId());
        Category category = categoryRepo.findCategoryById(itemContext.getCategoryId());
        FoodItem_Portion fo = foodItemPortion.findFoodItem_PortionById(itemContext.getFoodItemPortionId());

        if(foodItem == null || category == null)
            return 0L;

        foodItem.setItemName(fo.getFoodItem().getItemName());

        foodItem.setQuantity(itemContext.getQuantity());
        foodItem.setCategory(category);

        return foodItem.getId();
    }

    @Override
    @Transactional
    public Long deleteFoodItem(Long id) {
        itemRepo.deleteById(id);
        return id;
    }
}
