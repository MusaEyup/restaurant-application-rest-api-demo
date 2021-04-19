package com.restaurant.Service.Impl;

import com.restaurant.Entity.Tables;
import com.restaurant.Repository.TablesRepository;
import com.restaurant.Service.TablesService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class TablesServiceImplTest {

    @MockBean
    TablesRepository tablesRepository;

    @Autowired
    TablesService tablesService;



    @Test
    void getAllTables() {
        Mockito.when(tablesRepository.findAll())
                .thenReturn(Stream.of(new Tables(), new Tables()).collect(Collectors.toList()));
        assertEquals(2, tablesService.getAllTables().size());
    }

    @Test
    void getAvailableTables() {
        List<Tables> tables = List.of(new Tables(1L, 3, true),
                                      new Tables(2L, 2, true),
                                      new Tables(3L, 4, false))  ;
        Mockito.when(tablesRepository.findAvailableTables())
                .thenReturn(tables.stream().filter(Tables::is_status).collect(Collectors.toList()));
        assertEquals(2,tablesService.getAvailableTables().size());
    }

    @Test
    void getTableById() {
        Tables table = new Tables(1L,2,true);
        Mockito.when(tablesRepository.findTableById(1L)).thenReturn(table);
        assertThat(tablesService.getTableById(1L).equals(table));
    }

    @Test
    void addTables() {
        /*Tables table = new Tables(1L, 2, false);
        Mockito.when(tablesRepository.save(table))
                .thenReturn(table.getId());
        assertThat(tablesService.addTables(a))*/
    }

    @Test
    void deleteTable() {
    }
}