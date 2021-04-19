package com.restaurant.Repository;

import com.restaurant.Entity.Portion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortionRepository extends CrudRepository<Portion, Long> {

    @Query(value = "SELECT p FROM Portion p")
    List<Portion> findAllPortions();

    @Query(value = "SELECT p FROM Portion p WHERE p.id = ?1")
    Portion findPortionById(Long id);



}
