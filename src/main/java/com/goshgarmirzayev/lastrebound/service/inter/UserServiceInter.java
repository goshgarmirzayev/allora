package com.goshgarmirzayev.lastrebound.service.inter;


import com.goshgarmirzayev.lastrebound.entity.User;

import java.util.List;

public interface UserServiceInter {
    public User findById(Integer id);

    public List<User> findAll();

    public int save(User user);

    public User update(com.goshgarmirzayev.lastrebound.bean.User user);
}
