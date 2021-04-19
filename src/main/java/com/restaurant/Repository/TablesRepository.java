package com.restaurant.Repository;

import com.restaurant.Entity.Tables;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TablesRepository extends CrudRepository<Tables, Long> {

    @Query(value = "select t from Tables t ")
    public List<Tables> findAll();

    @Query(value = "select max(t.id) from Tables t")
    public Long findMaxId();

    @Query(value = "select t from Tables t where t.id = :id")
    public Tables findTableById(@Param("id") Long id);

    @Query(value = "select t from Tables t where t._status = false")
    public List<Tables> findAvailableTables();
}
