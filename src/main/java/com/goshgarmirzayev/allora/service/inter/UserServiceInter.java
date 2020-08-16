package com.goshgarmirzayev.allora.service.inter;


import com.goshgarmirzayev.allora.entity.User;

import java.util.List;

public interface UserServiceInter {
    public User findById(Integer id);

    public List<User> findAll();

    public int save(User user);

    public User update(com.goshgarmirzayev.allora.bean.User user);
}
