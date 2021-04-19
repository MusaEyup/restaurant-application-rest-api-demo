package com.restaurant.Repository;

import com.restaurant.Entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    @Query(value = "select o from Order o")
    public List<Order> findAll();

    @Query(value = "select o from Order o where o._status = true")
    public List<Order> findAllActiveOrders();

    @Query(value = "select o from Order o where o._status = true and o.table.id = :id")
    public Order findActiveOrderByTableNo(@Param("id") Long id);

    @Query(value = "select o from Order o where o._status = false")
    public List<Order> findAllHistoryOrders();

    @Query(value = "select o from Order o where o.id = :id")
    public Order findOrderById(@Param("id") Long id);


}
