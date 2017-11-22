package com.vinc.service.api;

import com.vinc.data.mapper.UserMapper;
import com.vinc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: vinc
 * @Description:
 * @Date: created in 16:41 2017/3/14
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public void addUser(User recode){
        userMapper.insert(recode);
    }

}
