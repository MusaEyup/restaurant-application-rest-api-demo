package com.restaurant.Service.Impl;

import com.restaurant.Entity.Order;
import com.restaurant.Entity.Tables;
import com.restaurant.Repository.OrderRepository;
import com.restaurant.Repository.TablesRepository;
import com.restaurant.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private TablesRepository tablesRepo;

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public List<Order> getAllActiveOrders() {
        return orderRepo.findAllActiveOrders();
    }



    @Override
    public List<Order> getHistoryOrders() {
        return orderRepo.findAllHistoryOrders();
    }

    @Override
    public Order getOrdersById(Long id) {
        return orderRepo.findOrderById(id);
    }

    @Override
    public Order getActiveOrderByTableNo(Long tableId) {
        return orderRepo.findActiveOrderByTableNo(tableId);
    }

    @Override
    @Transactional
    public Long openOrder(Long id) {

        Tables table = tablesRepo.findTableById(id);
        if(table == null || table.is_status()){
            return 0L;
        }

        table.set_status(true);
        tablesRepo.save(table);

        Order order = new Order(true, LocalDateTime.now(),LocalDateTime.now(),  table);
        orderRepo.save(order);


        return order.getId();
    }

    @Override
    @Transactional
    public Long closeOrder(Long orderId) {

        Order order = orderRepo.findOrderById(orderId);
        if(order==null)
            return 0L;

        order.getTable().set_status(false);
        order.set_status(false);
        order.setClosingDate(LocalDateTime.now());
        orderRepo.save(order);
        return order.getId();

    }
}
