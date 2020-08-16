package com.goshgarmirzayev.lastrebound.bean;

import com.goshgarmirzayev.lastrebound.entity.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomUserDetail extends org.springframework.security.core.userdetails.User {
    private com.goshgarmirzayev.lastrebound.entity.User user;

    public CustomUserDetail(com.goshgarmirzayev.lastrebound.entity.User user, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

}
