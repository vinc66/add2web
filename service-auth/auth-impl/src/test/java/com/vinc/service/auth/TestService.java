package com.vinc.service.auth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: vinc
 * @Description:
 * @Date: created in 11:10 2017/3/21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-test.xml"})
public class TestService {

    @Autowired
    private AccountService accountService;

    @Test
    public void testAuth(){
        System.out.println(accountService.getName(111));
        while(true){}

    }

}
