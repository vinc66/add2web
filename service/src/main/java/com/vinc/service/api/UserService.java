package com.vinc.service.api;

import com.vinc.data.mapper.UserMapper;
import com.vinc.domain.User;
import com.vinc.service.event.RegisterEvent;
import com.vinc.service.event.RelationEvent;
import com.vinc.service.notify.UserNotify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @Author: vinc
 * @Description:
 * @Date: created in 16:41 2017/3/14
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserNotify userNotify;

    private static Random random = new Random();

    public User getUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }


    public void addUser(User recode){

        recode.setId(random.nextInt(10000));
        userNotify.publish(new RegisterEvent(recode));

        userNotify.publish(new RelationEvent(recode));

//        userMapper.insert(recode);
    }

}
