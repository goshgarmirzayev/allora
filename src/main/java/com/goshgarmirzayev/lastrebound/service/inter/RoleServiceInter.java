package com.goshgarmirzayev.lastrebound.service.inter;

import com.goshgarmirzayev.lastrebound.entity.AuthRole;

import java.util.List;

public interface RoleServiceInter {
    public AuthRole findById(Integer id);

    public List<AuthRole> findAll();

    public AuthRole save(AuthRole role);
    
}
