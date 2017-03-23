package com.vinc.service.auth.impl;

import com.vinc.service.auth.AccountService;
import org.springframework.stereotype.Service;

/**
 * @Author: vinc
 * @Description:
 * @Date: created in 18:52 2017/3/20
 */

@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public String getName(int id) {
        return "the name is :" + id;
    }
}
