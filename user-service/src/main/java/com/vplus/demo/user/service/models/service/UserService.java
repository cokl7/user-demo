package com.vplus.demo.user.service.models.service;

import com.vplus.demo.user.service.models.pojo.User;

public interface UserService {
    User queryById(Long id);
}
