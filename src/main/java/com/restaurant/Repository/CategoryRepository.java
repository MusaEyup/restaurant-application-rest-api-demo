package com.restaurant.Repository;

import com.restaurant.Entity.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Query(value = "select c from Category c where c.deleted = false")
    List<Category> findAll();

    @Query(value = "select max(c.id) from Category c")
    Long findMaxId();

    @Query(value = "select c from Category c where c.name = :name and c.deleted = false")
    Category findCategoryByName(@Param("name") String name);

    @Query(value = "select c from Category c where c.id = :id and c.deleted = false")
    Category findCategoryById(@Param("id") Long id);


}
