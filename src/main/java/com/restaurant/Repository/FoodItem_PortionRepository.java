package com.restaurant.Repository;

import com.restaurant.Entity.FoodItem_Portion;
import com.restaurant.Entity.Portion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;

@Repository
public interface FoodItem_PortionRepository extends CrudRepository<FoodItem_Portion, Long> {

    @Query("SELECT f FROM FoodItem_Portion f WHERE f.id = ?1")
    FoodItem_Portion findFoodItem_PortionById(Long id);

    @Query("SELECT f FROM FoodItem_Portion f WHERE f.foodItem.itemName = ?1")
    List<FoodItem_Portion> findFoodItem_PortionByFoodItemName(String foodName);

    @Query("SELECT f FROM FoodItem_Portion f WHERE f.foodItem.id = ?1")
    List<FoodItem_Portion> findFoodItem_PortionByFoodItemId(Long id);

    @Query("SELECT f.portion FROM FoodItem_Portion f WHERE f.foodItem.id = ?1")
    List<Portion> findPortionsByFoodItemId(Long id);

    List<FoodItem_Portion> findAll();
}
