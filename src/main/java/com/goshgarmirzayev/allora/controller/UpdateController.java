package com.goshgarmirzayev.allora.controller;

import com.goshgarmirzayev.allora.dao.UserDataInter;

import com.goshgarmirzayev.allora.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateController {

    @Autowired
    UserDataInter userDataInter;

    @RequestMapping("/checkUser/{email}")
    public String checkUser(@PathVariable("email") String email) {
        User user = userDataInter.findByEmail(email);
        if (user != null) {
            return "-1";
        } else {
            return "0";
        }
    }
}
