package com.restaurant.Service.Impl;

import com.restaurant.Context.FoodItemContext;
import com.restaurant.Context.FoodOrderContext;
import com.restaurant.Context.PortionContext;
import com.restaurant.Entity.*;
import com.restaurant.Repository.*;
import com.restaurant.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FoodItem_PortionServiceImpl implements FoodItem_PortionService {

    @Autowired
    private FoodItem_PortionRepository foodItem_portionRepository;
    @Autowired
    private FoodItemRepository foodItemRepo;

    @Autowired
    private ImageRepository imageRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private PortionRepository portionRepo;

    @Override
    public FoodItem_Portion getById(Long id) {
        return foodItem_portionRepository.findFoodItem_PortionById(id);
    }

    @Override
    public List<FoodItem_Portion> getByFoodItemName(String foodName) {
        return foodItem_portionRepository.findFoodItem_PortionByFoodItemName(foodName);
    }

    @Override
    public List<FoodItem_Portion> getByFoodItemId(Long id) {
        return foodItem_portionRepository.findFoodItem_PortionByFoodItemId(id);
    }

    @Override
    public List<Portion> getPortionByFoodItemId(Long id) {
        return foodItem_portionRepository.findPortionsByFoodItemId(id);
    }

    @Override
    public List<FoodItem_Portion> getAll() {
        return foodItem_portionRepository.findAll();
    }

    @Override
    @Transactional
    public List<Long> addFoodItemsPortions(FoodItemContext foodItemContext) {

        ItemImages images = imageRepo.findById(foodItemContext.getImageId()).orElse(null);

        Category category = categoryRepo.findCategoryById(foodItemContext.getCategoryId());

        FoodItem foodItem = new FoodItem();
        foodItem.setItemName(foodItemContext.getItemName());
        foodItem.setQuantity(foodItemContext.getQuantity());
        foodItem.setCategory(category);
        foodItem.setItemImages(images);

        /*FoodItem foodItem2 = foodItemRepo.findFoodItemByNameAndCategory(foodItem.getItemName(), category.getId()).orElse(null);

        FoodItem oldOne = null;
        if(foodItem2 != null){
            if(foodItem2.isDeleted())
                foodItem2.setDeleted(false);
            oldOne.setQuantity(foodItemContext.getQuantity());
            oldOne.set
             oldOne = foodItemRepo.save(foodItem);
            *
        }
        */



        FoodItem foodItem1 =  foodItemRepo.save(foodItem);

        List<FoodItem_Portion> foodItem_portionList = new ArrayList<>();

        for(PortionContext portionContext : foodItemContext.getPortionContextList()){
            
            FoodItem_Portion foodItemPortion = new FoodItem_Portion();
            foodItemPortion.setFoodItem(foodItem1);
            foodItemPortion.setUnitPrice(portionContext.getUnitPrice());
            Portion portion;

            portion = (portionContext.getId() == 0) ?
                        portionRepo.save(new Portion(portionContext.getName(), portionContext.getRatio())) :
                        portionRepo.findPortionById(portionContext.getId());

            foodItemPortion.setPortion(portion);
            foodItem_portionList.add(foodItemPortion);
        }
        List<Long> Ids = new ArrayList<>();

        foodItem_portionRepository.saveAll(foodItem_portionList).forEach( f -> {
            Ids.add(f.getId());
        });

        return Ids;
    }
}
