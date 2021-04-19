package com.restaurant.Controller;

import com.restaurant.Entity.Portion;
import com.restaurant.Service.PortionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/portion")
public class PortionController {

    @Autowired
    private PortionService portionService;

    @GetMapping("/")
    public List<Portion> getAllPortions(){
        return portionService.getAll();
    }

    @GetMapping("/{id}")
    public Portion getPortionById(@PathVariable("id")Long id){
        return portionService.getById(id);
    }

}
