package com.cake.controller;

import com.cake.entity.User;
import com.cake.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by XuRui's Hands.
 * User:XuRui
 * Date:2017/1/2
 * Time:20:18
 */

@Controller
@RequestMapping("/user")
public class UserController {

    public UserController() {
        System.out.println("初始化 demo 控制器");
    }

    @Autowired
    private UserService userService;


    @ResponseBody
    @RequestMapping("/hello")
    private String hello() {
        return "hello";
    }

    @ResponseBody
    @RequestMapping("/loadAllUser")
    private List<User> LoadAllUser(@RequestParam(value = "sign", required = false, defaultValue = "") int sign) {
        List<User> list = null;
        try {
            if (sign == 1)
                list = userService.loadAllUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
