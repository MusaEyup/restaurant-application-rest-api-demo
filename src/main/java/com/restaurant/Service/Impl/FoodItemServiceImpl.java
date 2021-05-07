package com.restaurant.Service.Impl;

import com.restaurant.Context.ItemContext;
import com.restaurant.Entity.Category;
import com.restaurant.Entity.FoodItem;
import com.restaurant.Entity.FoodItem_Portion;
import com.restaurant.Repository.CategoryRepository;
import com.restaurant.Repository.FoodItemRepository;
import com.restaurant.Repository.FoodItem_PortionRepository;
import com.restaurant.Service.FoodItemService;
import com.restaurant.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FoodItemServiceImpl implements FoodItemService {

    private final FoodItemRepository itemRepo;
    private final FoodItem_PortionRepository foodItemPortion;
    private final CategoryRepository categoryRepo;
    private final ImageService imageService;

    @Autowired
    public FoodItemServiceImpl(FoodItemRepository itemRepo, FoodItem_PortionRepository foodItemPortion, CategoryRepository categoryRepo, ImageService imageService) {
        this.itemRepo = itemRepo;
        this.foodItemPortion = foodItemPortion;
        this.categoryRepo = categoryRepo;
        this.imageService = imageService;
    }

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
    public Long updateFoodItemDetails(ItemContext itemContext) {


        FoodItem foodItem = itemRepo.findFoodItemById(itemContext.getId());
        if(itemContext.getCategoryId() != 0){
            Category category = categoryRepo.findCategoryById(itemContext.getCategoryId());
            foodItem.setCategory(category);
        }
        if(itemContext.getItemName() != null){
            foodItem.setItemName(itemContext.getItemName());
        }
        if(itemContext.getImageId() != 0){
            Long oldImageId = foodItem.getItemImages().getId();
            foodItem.setItemImages(imageService.getFile(itemContext.getImageId()));
            imageService.deleteImageById(oldImageId);
        }
        itemRepo.save(foodItem);
        return itemContext.getId();
    }
    @Override
    @Transactional
    public Long deleteFoodItem(Long id) {

        FoodItem foodItem = itemRepo.findFoodItemById(id);
        foodItem.setDeleted(true);
        itemRepo.save(foodItem);

        return id;
    }

    @Override
    public Category getCategoryByItemId(Long id) {
        return itemRepo.findCategoryByFoodItemId(id);
    }

    @Override
    public List<FoodItem> getAllFoodItemsByName(String name) {

        return itemRepo.findAllByName(name);
    }
}
