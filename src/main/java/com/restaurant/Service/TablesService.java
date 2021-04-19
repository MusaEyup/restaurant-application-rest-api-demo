package com.restaurant.Service;

import com.restaurant.Context.TablesContext;
import com.restaurant.Entity.Tables;

import java.util.List;

public interface TablesService {
    List<Tables> getAllTables();
    Tables getTableById(Long id);
    Long addTables(TablesContext table);
    Long deleteTable(Long id);
    List<Tables> getAvailableTables();
}
