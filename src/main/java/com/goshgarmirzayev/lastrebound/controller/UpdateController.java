package com.goshgarmirzayev.lastrebound.controller;

import com.goshgarmirzayev.lastrebound.dao.UserDataInter;

import com.goshgarmirzayev.lastrebound.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
