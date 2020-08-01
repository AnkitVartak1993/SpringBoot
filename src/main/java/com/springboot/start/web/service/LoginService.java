package com.springboot.start.web.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
    public boolean validateUser(String userid, String password) {
        return userid.equals("test")&&password.equals("pass");
    };
}
