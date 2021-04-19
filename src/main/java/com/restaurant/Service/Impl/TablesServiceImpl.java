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
        Long id = (tablesRepo.findMaxId() == null) ? 1 : tablesRepo.findMaxId() + 1;

        Tables table = new Tables(
                id,
                tableContext.getSeatCount(),
                false
        );
        tablesRepo.save(table);

        return id;
    }

    @Override
    @Transactional
    public Long deleteTable(Long id) {

        tablesRepo.deleteById(id);
        return id;


    }


}
