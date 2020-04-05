package com.xduweb.web.controller;

import com.xduweb.web.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Component
@Controller
public class UserController {
    @Resource
    private UserService userService = new UserService();


    @RequestMapping("/")
    public String getAll(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/login/success")
    public String success(){
        return "success";
    }

    @RequestMapping("/login/failed")
    public String failed(){
        return "failed";
    }

    @ResponseBody
    @RequestMapping("/login/compare")
    public String compare(@RequestParam("user_id") Long user_id,@RequestParam("password") String password){
        if(userService.canLogin(user_id,password)){
            return "success";
        }
        else {
            return "failed";
        }
    }
}
