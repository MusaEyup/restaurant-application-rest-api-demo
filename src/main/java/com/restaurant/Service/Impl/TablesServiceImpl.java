package com.restaurant.Service.Impl;

import com.restaurant.Context.TablesContext;
import com.restaurant.Entity.Tables;
import com.restaurant.Repository.TablesRepository;
import com.restaurant.Service.TablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TablesServiceImpl implements TablesService {


    @Autowired
    TablesRepository tablesRepo;

    @Override
    public List<Tables> getAllTables() {
        return tablesRepo.findAll();
    }

    @Override
    public List<Tables> getAvailableTables() {
        return tablesRepo.findAvailableTables();
    }

    @Override
    public Tables getTableById(Long id) {
        return tablesRepo.findTableById(id);
    }

    @Override
    @Transactional
    public Long addTables(TablesContext tableContext) {

        Tables table = getTableById(tableContext.getTableId());
        if(table != null) {

            
                table.setDeleted(false);
                return table.getId();

        }
        table = new Tables();
        table.setId(tableContext.getTableId());
        table.set_status(false);
        table.setDeleted(false);
        table.setSeatCount(tableContext.getSeatCount());
        tablesRepo.save(table);
        return table.getId();
    }

    @Override
    @Transactional
    public Long deleteTable(Long id) {

        Tables table = tablesRepo.findTableById(id);

        table.setDeleted(true);
        tablesRepo.save(table);
        return id;
    }
}







