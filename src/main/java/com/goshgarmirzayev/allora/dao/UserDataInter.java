package com.goshgarmirzayev.allora.dao;

import com.goshgarmirzayev.allora.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataInter extends JpaRepository<User, Integer> {
    User findByEmailAndEnabled(String email, boolean enabled);

    User findByEmail(String email);
}
