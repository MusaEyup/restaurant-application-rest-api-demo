package com.restaurant.Repository;

import com.restaurant.Entity.Category;
import com.restaurant.Entity.FoodItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodItemRepository extends CrudRepository<FoodItem, Long> {

    @Query(value = "SELECT f FROM FoodItem f WHERE  f.deleted=false")
    List<FoodItem> findAll();

    @Query(value = "SELECT f FROM FoodItem f WHERE f.category.id = ?1 AND f.deleted=false")
    List<FoodItem> findAllByCategory(Long categoryId);

    @Query(value ="SELECT f FROM FoodItem f WHERE f.id = :id AND f.deleted=false")
    FoodItem findFoodItemById(Long id);

    @Query(value = "SELECT f FROM FoodItem f WHERE f.itemName = ?1 AND f.category.id = ?2")
    Optional<FoodItem> findFoodItemByNameAndCategory(String foodName, Long categoryId);

    @Query(value = "SELECT f.category FROM FoodItem  f WHERE f.id = ?1")
    Category findCategoryByFoodItemId(Long id);

}
