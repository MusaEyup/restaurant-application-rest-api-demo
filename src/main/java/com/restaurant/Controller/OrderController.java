package com.restaurant.Controller;

import com.restaurant.Entity.Order;
import com.restaurant.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired

    private OrderService orderService;

    @GetMapping("/")
    public List<Order> getAll(){
        return orderService.getAllOrders();
    }

    @GetMapping("/active")
    public List<Order> getAllActiveOrders(){

        return orderService.getAllActiveOrders();

    }
    @GetMapping("/active/{id}")
    public Long getActiveOrderByTableNo(@PathVariable("id") Long tableId){

        Order order = orderService.getActiveOrderByTableNo(tableId);
        if(order == null){
            return null;
        }
        return order.getId();
    }
    @GetMapping("/history")
    public List<Order> getHistoryOrders(){

        return orderService.getHistoryOrders();

    }
    @GetMapping("/{id}")
    public Order getById(@PathVariable("id") Long id){
        return orderService.getOrdersById(id);
    }

    @GetMapping("/open/{id}")
    public Long openNewOrder(@PathVariable("id") Long tableId) {
        return orderService.openOrder(tableId);
    }

    @PutMapping("/{id}")
    public Long closeOrder(@PathVariable("id") Long id) {
        return orderService.closeOrder(id);
    }
}
