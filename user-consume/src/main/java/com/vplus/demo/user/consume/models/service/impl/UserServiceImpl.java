package com.vplus.demo.user.consume.models.service.impl;

import com.vplus.demo.user.consume.models.clent.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vplus.demo.user.consume.models.dao.UserDao;
import com.vplus.demo.user.consume.models.pojo.User;
import com.vplus.demo.user.consume.models.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserClient userClient;

    @Override
    public List<User> queryUserByIds(List<Long> ids) {
        List<User> users = new ArrayList<>();
        for (Long id : ids) {
            //RestTemplate 请求方式
//            User user = this.userDao.queryUserById(id);
            //feign 请求方式
            User user = userClient.queryUserById(id);
            users.add(user);
        }
        return users;
    }
}
