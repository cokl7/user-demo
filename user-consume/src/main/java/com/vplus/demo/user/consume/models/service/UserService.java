package com.vplus.demo.user.consume.models.service;

import com.vplus.demo.user.consume.models.pojo.User;

import java.util.List;

public interface UserService {
    List<User> queryUserByIds(List<Long> ids);
}
