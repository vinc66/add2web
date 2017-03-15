package com.vinc.web.controller;

import com.vinc.domain.User;
import com.vinc.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: vinc
 * @Description:
 * @Date: created in 18:08 2017/3/13
 */
@RequestMapping
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public String getUser(Model model) {
        User user = userService.getUserById(1);
        System.out.print(user);
        model.addAttribute("user",user);
        return "index";
    }

}
