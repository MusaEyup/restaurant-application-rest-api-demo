package com.restaurant.Service.Impl;

import com.restaurant.Context.FoodItemContext;
import com.restaurant.Context.FoodItem_PortionContext;
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


    private final FoodItem_PortionRepository foodItem_portionRepository;
    private final FoodItemRepository foodItemRepo;
    private final ImageRepository imageRepo;
    private final CategoryRepository categoryRepo;
    private final PortionRepository portionRepo;

    @Autowired
    public FoodItem_PortionServiceImpl(FoodItem_PortionRepository foodItem_portionRepository, FoodItemRepository foodItemRepo, ImageRepository imageRepo, CategoryRepository categoryRepo, PortionRepository portionRepo) {
        this.foodItem_portionRepository = foodItem_portionRepository;
        this.foodItemRepo = foodItemRepo;
        this.imageRepo = imageRepo;
        this.categoryRepo = categoryRepo;
        this.portionRepo = portionRepo;
    }

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
            foodItemPortion.setDeleted(false);
            foodItem_portionList.add(foodItemPortion);
        }
        List<Long> Ids = new ArrayList<>();

        foodItem_portionRepository.saveAll(foodItem_portionList).forEach( f -> {
            Ids.add(f.getId());
        });

        return Ids;
    }

    @Override
    @Transactional
    public List<Long> updateFoodItemPortions(List<FoodItem_PortionContext> contexts) {


        List<Long> updatedList = new ArrayList<>();

        FoodItem foodItem = foodItemRepo.findFoodItemById(contexts.get(0).getFoodItemId());
        foodItem.setQuantity(contexts.get(0).getQuantity());
        foodItemRepo.save(foodItem);
        for (int i = 0; i < contexts.size(); i++){
            FoodItem_Portion foodItem_Portion = null;

            if(contexts.get(i).getId() == 0){
                foodItem_Portion = new FoodItem_Portion();
                foodItem_Portion.setFoodItem(foodItemRepo.findFoodItemById(contexts.get(i).getFoodItemId()));

                Portion portion1 = portionRepo.save(new Portion(contexts.get(i).getPortionName(),  contexts.get(i).getRatio()));
                foodItem_Portion.setPortion(portion1);

            }
            else{
                foodItem_Portion = foodItem_portionRepository.findFoodItem_PortionById(contexts.get(i).getId());
            }

            Portion portion = foodItem_Portion.getPortion();

            if(!contexts.get(i).getPortionName().equals(portion.getName())
                    || contexts.get(i).getRatio() != portion.getCalculate()){
                Portion portion1 = portionRepo.save(new Portion(contexts.get(i).getPortionName(),  contexts.get(i).getRatio()));
                foodItem_Portion.setPortion(portion1);
            }


            foodItem_Portion.setUnitPrice(contexts.get(i).getPrice());
            foodItem_Portion.setDeleted(false);
            updatedList.add(foodItem_portionRepository.save(foodItem_Portion).getId());
        }


        return updatedList;
    }

    @Override
    @Transactional
    public Long deleteFoodItemPortionById(Long id) {

        FoodItem_Portion foodItemPortion = foodItem_portionRepository.findFoodItem_PortionById(id);
        foodItemPortion.setDeleted(true);
        foodItem_portionRepository.save(foodItemPortion);

        return id;
    }
}
