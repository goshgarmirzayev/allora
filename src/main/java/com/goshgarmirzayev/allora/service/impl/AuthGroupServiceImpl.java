package com.goshgarmirzayev.allora.service.impl;

import com.goshgarmirzayev.allora.dao.AuthGroupDataInter;
import com.goshgarmirzayev.allora.entity.AuthGroup;
import com.goshgarmirzayev.allora.service.inter.AuthGroupServiceInter;
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
