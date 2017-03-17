package com.vinc.web.controller;

import com.vinc.data.repository.redis.ClusterRepository;
import com.vinc.data.repository.redis.SingleRepository;
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
    @Autowired
    private SingleRepository singleRepository;
    @Autowired
    private ClusterRepository clusterRepository;

    @RequestMapping("/getUser")
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
        return "index";
    }

}
