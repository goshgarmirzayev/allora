package com.goshgarmirzayev.lastrebound.service.impl;

import com.goshgarmirzayev.lastrebound.dao.AuthGroupDataInter;
import com.goshgarmirzayev.lastrebound.entity.AuthGroup;
import com.goshgarmirzayev.lastrebound.service.inter.AuthGroupServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthGroupServiceImpl implements AuthGroupServiceInter {
    @Autowired
    AuthGroupDataInter authGroupDataInter;

    @Override
    public AuthGroup findById(Integer id) {
        return authGroupDataInter.findById(id).get();
    }
}
