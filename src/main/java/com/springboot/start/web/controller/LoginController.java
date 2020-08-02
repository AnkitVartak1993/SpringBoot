package com.springboot.start.web.controller;

import com.springboot.start.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String showLoginPage(ModelMap model) {
        return  "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password) {

        if(!loginService.validateUser(name,password)){
            model.put("errorMessage","Invalid Credentials");
            return "/login";
        }
        model.put("name", name);
        return "welcome";
    }
}
