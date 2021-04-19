package com.restaurant.Controller;

import com.restaurant.Context.FoodOrderContext;
import com.restaurant.Context.ItemContext;
import com.restaurant.Entity.FoodItem_Order;
import com.restaurant.Service.FoodItem_OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item_order")
public class FoodItem_OrderController {

    @Autowired
    FoodItem_OrderService itemOrderService;

    @GetMapping("/")
    public List<FoodItem_Order> getAllFoodItem_Order(){

        return itemOrderService.getAllFoodItem_Order();
    }

    @PostMapping("/add")
    public Long addMenuItem_Order(@RequestBody FoodOrderContext foodOrderContext) {

        return itemOrderService.addFoodItem_Order(foodOrderContext);

    }

    @PostMapping("/addlist")
    public Long addFoodItem_OrderList(@RequestBody FoodOrderContext itemList){
        return itemOrderService.addFoodItem_OrderList(itemList);
    }


    @DeleteMapping("/delete/{id}")
    public Long deleteOrderItem(@PathVariable("id") Long id) {
        return itemOrderService.deleteFoodItem_Order(id);
    }

    @PutMapping("/{id}")
    public Long updateOrderItem(@PathVariable("id") Long foodItemOrderId, @RequestBody FoodOrderContext foodOrderContext){
            return itemOrderService.updateFoodItem_Order(foodItemOrderId, foodOrderContext);
    }


}
