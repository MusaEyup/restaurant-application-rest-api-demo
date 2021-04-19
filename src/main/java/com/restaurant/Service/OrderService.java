package com.restaurant.Service;

import com.restaurant.Entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    List<Order> getAllActiveOrders();
    List<Order> getHistoryOrders();
    Order getOrdersById(Long id);
    Order getActiveOrderByTableNo(Long tableId);
    Long openOrder(Long tableId);
    Long closeOrder(Long orderId);

}
