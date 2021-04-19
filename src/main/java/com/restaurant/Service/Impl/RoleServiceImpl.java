package com.restaurant.Service.Impl;


import com.restaurant.Entity.Role;
import com.restaurant.Repository.RoleRepository;
import com.restaurant.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepo;

    @Override
    public List<Role> getAll() {
        return roleRepo.findAll();
    }
}
