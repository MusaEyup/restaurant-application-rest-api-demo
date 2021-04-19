package com.restaurant.Repository;

import com.restaurant.Entity.ItemImages;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends CrudRepository<ItemImages, Long> {
}
