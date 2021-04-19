package com.restaurant.Repository;

import com.restaurant.Entity.FoodItem_Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FoodItem_OrderRepository extends CrudRepository<FoodItem_Order, Long> {

    @Query(value = "select fo from FoodItem_Order fo")
    List<FoodItem_Order> findAll();

    @Query(value = "select fo from FoodItem_Order fo where fo.id = ?1")
    FoodItem_Order findFoodItem_OrderById(Long id);

    @Query(value = "select fo.id from FoodItem_Order fo where fo = ?1")
    Long findId( FoodItem_Order foi);



}
