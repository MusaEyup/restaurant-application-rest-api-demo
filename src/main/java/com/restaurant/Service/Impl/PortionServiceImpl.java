package com.restaurant.Service.Impl;

import com.restaurant.Entity.Portion;
import com.restaurant.Repository.PortionRepository;
import com.restaurant.Service.PortionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortionServiceImpl implements PortionService {

    @Autowired
    private PortionRepository portionRepo;

    @Override
    public List<Portion> getAll() {
        return portionRepo.findAllPortions();
    }

    @Override
    public Portion getById(Long id) {
        return portionRepo.findPortionById(id);
    }

    @Override
    public Portion addNewPortion(String portionName, float ratio) {
        return portionRepo.save(new Portion(portionName, ratio));
    }
}
