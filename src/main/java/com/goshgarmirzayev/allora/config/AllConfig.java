package com.goshgarmirzayev.allora.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.TimeZone;

@Configuration
@EnableScheduling
public class AllConfig {


    @Bean("pwdEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Baku"));
        //Create upload directory
        File file=new File("/projects/allora/images");
        if(!file.exists()){
            file.mkdirs();
        }
    }

}
