package com.restaurant.Controller;

import com.restaurant.Context.ItemContext;
import com.restaurant.Entity.FoodItem;
import com.restaurant.Repository.FoodItemRepository;
import com.restaurant.Service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
public class FoodItemController {

    @Autowired
    FoodItemService foodItemService;



    @GetMapping("/")
    public List<FoodItem> getAll(){
        return foodItemService.getAllFoodItems();
    }

    @GetMapping("/category/{id}")
    public List<FoodItem> getFookItemsByCategory(@PathVariable("id") Long id){
        return foodItemService.getFoodItemsByCategory(id);
    }
    @GetMapping("/{id}")
    public FoodItem getOne(@PathVariable("id") Long id){
        return foodItemService.getOne(id);
    }

    @PostMapping("/")
    public Long addNewItem1(@RequestBody ItemContext itemContext) {

        return foodItemService.addFoodItem(itemContext);
    }

    @PostMapping("/add")
    public Long addNewItem(@RequestBody ItemContext itemContext) {

        return foodItemService.addFoodItem(itemContext);
    }

    @PutMapping("/update")
    public Long update(@RequestBody ItemContext itemContext) {
        return foodItemService.updateFoodItem(itemContext);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable("id") Long id) {

        return foodItemService.deleteFoodItem(id);
    }
}
