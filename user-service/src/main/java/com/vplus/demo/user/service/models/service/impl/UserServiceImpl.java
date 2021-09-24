package com.vplus.demo.user.service.models.service.impl;

import com.vplus.demo.user.service.models.mapper.UserMapper;
import com.vplus.demo.user.service.models.pojo.User;
import com.vplus.demo.user.service.models.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryById(Long id) {
        // 为了演示超时现象，我们在这里然线程休眠,时间随机 0~2000毫秒
//        try {
//            Thread.sleep(new Random().nextInt(2000));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return userMapper.selectByPrimaryKey(id);
    }

}
