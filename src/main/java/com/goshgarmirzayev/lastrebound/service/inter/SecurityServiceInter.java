package com.goshgarmirzayev.lastrebound.service.inter;


import com.goshgarmirzayev.lastrebound.bean.CustomUserDetail;
import org.springframework.stereotype.Service;

@Service
public interface SecurityServiceInter {

     CustomUserDetail getLoggedInUserDetails();

     void reloadRoles();
}
