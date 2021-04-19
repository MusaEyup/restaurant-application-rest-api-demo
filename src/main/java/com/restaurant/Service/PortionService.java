package com.restaurant.Service;

import com.restaurant.Entity.Portion;

import java.util.List;

public interface PortionService {
    List<Portion> getAll();
    Portion getById(Long id);
    Portion addNewPortion(String portionName, float ratio);

}
