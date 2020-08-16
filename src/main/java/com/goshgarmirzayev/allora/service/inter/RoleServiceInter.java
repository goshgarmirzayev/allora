package com.goshgarmirzayev.allora.service.inter;

import com.goshgarmirzayev.allora.entity.AuthRole;

import java.util.List;

public interface RoleServiceInter {
    public AuthRole findById(Integer id);

    public List<AuthRole> findAll();

    public AuthRole save(AuthRole role);
    
}
