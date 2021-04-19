package com.restaurant.Service.Impl;

import com.restaurant.Context.FoodOrderContext;
import com.restaurant.Context.ItemContext;
import com.restaurant.Entity.*;
import com.restaurant.Repository.*;
import com.restaurant.Service.FoodItem_OrderService;
import com.restaurant.Service.FoodItem_PortionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FoodItem_OrderServiceImpl implements FoodItem_OrderService {

    @Autowired
    private FoodItem_OrderRepository itemOrderRepo;
    @Autowired
    private FoodItemRepository itemRepo;
    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private EmployeeRepository employeeRepo;
    @Autowired
    private FoodItem_PortionService foodItem_portionService;
    @Autowired
    private FoodItem_PortionRepository foodItem_portionRepository;

    @Override
    public List<FoodItem_Order> getAllFoodItem_Order() {
        return itemOrderRepo.findAll();
    }

    // add one item food to table
    @Override
    @Transactional
    public Long addFoodItem_Order(FoodOrderContext item) {

        FoodItem_Portion foodItem_portion = foodItem_portionService.getById(item.getFoodItem_PortionId());
        Order order = orderRepo.findOrderById(item.getOrderId());

        Employee employee = employeeRepo.findEmployeeById(item.getEmployeeId());
        if(foodItem_portion == null || order == null)
            return 0L;

        FoodItem foodItem = foodItem_portion.getFoodItem();
        foodItem.setQuantity(foodItem_portion.getFoodItem().getQuantity() - (foodItem_portion.getPortion().getCalculate() * item.getQuantity()));

        //foodItemPoriton gelecek
        FoodItem_Order foodItemOrder = new FoodItem_Order(order,foodItem_portion,item.getQuantity(),item.getPrice(), LocalDateTime.now(), employee);
        itemOrderRepo.save(foodItemOrder);
        itemRepo.save(foodItem);

        return foodItemOrder.getId();
    }

    // delete food item from table
    @Override
    @Transactional
    public Long deleteFoodItem_Order(Long id) {
        FoodItem_Order fo = itemOrderRepo.findFoodItem_OrderById(id);
        if(fo == null)
            return null;
        FoodItem foodItem = fo.getFoodItem_Portion().getFoodItem();


        foodItem.setQuantity(foodItem.getQuantity() + (fo.getQuantity()* fo.getFoodItem_Portion().getPortion().getCalculate()));
        //itemOrderRepo.deleteById(fo.getId());
        itemOrderRepo.delete(fo);
        itemRepo.save(foodItem);
        return fo.getId();
    }

    // add a list of food item to table
    @Override
    public Long addFoodItem_OrderList(FoodOrderContext orderItemList) {

        Order order = orderRepo.findOrderById(orderItemList.getOrderId());
        Employee employee = employeeRepo.findEmployeeById(orderItemList.getEmployeeId());
        if(order == null ||employee == null)
            return 0L;
        for (ItemContext item: orderItemList.getItemList()) {

            FoodItem_Portion foodItem_portion = foodItem_portionService.getById(item.getFoodItemPortionId());

            FoodItem foodItem = foodItem_portion.getFoodItem();

            foodItem.setQuantity(foodItem.getQuantity() - (foodItem_portion.getPortion().getCalculate() * item.getQuantity()));


            FoodItem_Order foodItemOrder = new FoodItem_Order(order,foodItem_portion,item.getQuantity(),item.getPrice(),LocalDateTime.now(), employee);
            itemOrderRepo.save(foodItemOrder);
            itemRepo.save(foodItem);
        }

        return order.getId();
    }

    @Override
    @Transactional
    public Long updateFoodItem_Order(Long foodItemOrderId, FoodOrderContext foodOrderContext) {

        //order
        FoodItem_Order foodItem_order = itemOrderRepo.findFoodItem_OrderById(foodItemOrderId);

        //old foodPortion
        FoodItem_Portion foodItemPortion =
                foodItem_portionRepository.findFoodItem_PortionById(foodItem_order.getFoodItem_Portion().getId());
        //old foodPortion.foodItem
        FoodItem foodItem = foodItemPortion.getFoodItem();
        //old quantity
        float oldQuantity = foodItem_order.getQuantity() * foodItemPortion.getPortion().getCalculate();
        //foodItem.setQuantity(foodItem.getQuantity() +  oldQuantity);
        itemRepo.save(foodItem);
        foodItemPortion = foodItem_portionService.getById(foodOrderContext.getFoodItem_PortionId());
        float newQuantity = foodOrderContext.getQuantity() * foodItemPortion.getPortion().getCalculate();
        foodItemPortion.getFoodItem().setQuantity(foodItem.getQuantity() - (newQuantity - oldQuantity));
        foodItem_order.setQuantity(foodOrderContext.getQuantity());
        foodItem_order.setFoodItem_Portion(foodItemPortion);
        foodItem_order.setPrice(foodOrderContext.getPrice());
        foodItem_order.set_date(LocalDateTime.now());
        itemOrderRepo.save(foodItem_order);

        return foodItem_order.getId();
    }


}
