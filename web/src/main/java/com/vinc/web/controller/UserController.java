package com.vinc.web.controller;

import com.alibaba.fastjson.JSON;
import com.vinc.domain.User;
import com.vinc.service.api.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: vinc
 * @Description:
 * @Date: created in 18:08 2017/3/13
 */
@Controller
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
//    @Autowired
//    private SingleRepository singleRepository;
//    @Autowired
//    private ClusterRepository clusterRepository;
//    @Autowired
//    private AccountService accountService;

    @RequestMapping("/getUser")
    @ResponseBody
    public String getUser(Model model) {

//        redis single test
//        String str = singleRepository.getName("engine:slot:-524190008");
//        System.out.println(str+"------------------single");

//        redis cluster test
//        String name = clusterRepository.getClusterName("engine:slot:-1879326606");
//        System.out.println(name+"------------------cluster");

          //mysql test
//        User user = userService.getUserById(1);
//        System.out.println(user);

//        String name = accountService.getName(1);
//        System.out.println(accountService.getName(20));
        User userById = userService.getUserById(1);
        return JSON.toJSONString(userById);
    }



    @RequestMapping("/set")
    @ResponseBody
    public String set(Model model) {
        User user = new User();
        user.setName("約翰");
        userService.addUser(user);
        return JSON.toJSONString(user);
    }

    @RequestMapping("/get")
    @ResponseBody
    public String get(Model model) {

        User user = userService.getUserById(2);

        return JSON.toJSONString(user);
    }




}
