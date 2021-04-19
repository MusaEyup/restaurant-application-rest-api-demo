package com.restaurant.Controller;

import com.restaurant.Context.FoodItemContext;
import com.restaurant.Entity.FoodItem_Portion;
import com.restaurant.Entity.Portion;
import com.restaurant.Service.FoodItem_PortionService;
import com.restaurant.Service.PortionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item_portion")
public class FoodItem_PortionController {

    @Autowired
    private FoodItem_PortionService foodItem_portionService;

    @GetMapping("/")
    public List<FoodItem_Portion> getAllFoodItem_Portion(){
        return foodItem_portionService.getAll();
    }
    @GetMapping("/{id}")
    public FoodItem_Portion getAllFoodItem_PortionById(@PathVariable Long id){
        return foodItem_portionService.getById(id);
    }

    @GetMapping("/name/{name}")
    public List<FoodItem_Portion> getByFoodItemName(@PathVariable("name") String foodName){
        return foodItem_portionService.getByFoodItemName(foodName);
    }

    @GetMapping("/foodItem/{id}")
    public List<FoodItem_Portion> getByFoodItemId(@PathVariable("id") Long id){
        return foodItem_portionService.getByFoodItemId(id);
    }

    @GetMapping("/item/{id}")
    public List<Portion> getPortionsByFoodItemId(@PathVariable("id") Long id){
        return foodItem_portionService.getPortionByFoodItemId(id);
    }

    @PostMapping("/")
    public List<Long> saveFoodItem(@RequestBody FoodItemContext foodItemContext){
        return foodItem_portionService.addFoodItemsPortions(foodItemContext);
    }
}
