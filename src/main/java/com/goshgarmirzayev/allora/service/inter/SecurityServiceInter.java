package com.goshgarmirzayev.allora.service.inter;


import com.goshgarmirzayev.allora.bean.CustomUserDetail;
import org.springframework.stereotype.Service;

@Service
public interface SecurityServiceInter {

     CustomUserDetail getLoggedInUserDetails();

     void reloadRoles();
}
