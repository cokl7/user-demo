package com.vplus.demo.user.consume.models.controller;

import com.vplus.demo.user.consume.models.pojo.User;
import com.vplus.demo.user.consume.models.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("consume")
public class ConsumeController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> consume(@RequestParam("ids") List<Long> ids) {
      return userService.queryUserByIds(ids);
    }
}
