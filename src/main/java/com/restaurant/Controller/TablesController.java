package com.restaurant.Controller;

import com.restaurant.Context.TablesContext;
import com.restaurant.Entity.Tables;
import com.restaurant.Service.TablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tables")
public class TablesController {

    @Autowired
    TablesService tablesService;
    @GetMapping("/")
    public List<Tables> getAll(){
        return tablesService.getAllTables();
    }

    @GetMapping("/{id}")
    public Tables getById(@PathVariable("id") Long id) {
        return tablesService.getTableById(id);
    }

    @GetMapping("/available")
    public List<Tables> getAvailableTables(){
        return tablesService.getAvailableTables();
    }

    @PostMapping("/add")
    public Long addTables(@RequestBody TablesContext table) {
        return tablesService.addTables(table);
    }
    @DeleteMapping("/{id}")
    public Long deleteTables(@PathVariable("id") Long id) {
        return tablesService.deleteTable(id);
    }

}
