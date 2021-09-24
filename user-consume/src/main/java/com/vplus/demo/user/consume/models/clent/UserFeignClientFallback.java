package com.vplus.demo.user.consume.models.clent;

import com.vplus.demo.user.consume.models.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientFallback  implements UserClient {
    @Override
    public User queryUserById(Long id) {
        User user = new User();
        user.setId(id);
        user.setUsername("用户查询出现异常");
        return user;
    }
}
