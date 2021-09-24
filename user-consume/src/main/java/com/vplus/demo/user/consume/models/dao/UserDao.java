package com.vplus.demo.user.consume.models.dao;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vplus.demo.user.consume.models.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @HystrixCommand(fallbackMethod = "queryUserByIdFallback")
    public User queryUserById(Long id) {
//        //url调用
//        String url = "http://localhost:8081/user/" + id;
//        return restTemplate.getForObject(url, User.class);
//        // 根据服务名称，获取服务实例
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
//        // 因为只有一个UserService,因此我们直接get(0)获取
//        ServiceInstance instance = instances.get(0);
//        // 获取ip和端口信息
//        String baseUrl = "http://"+instance.getHost() + ":" + instance.getPort()+"/user/";
//        // 我们测试多次查询，
//        User forObject = this.restTemplate.getForObject(baseUrl + id, User.class);
//        return forObject;
        //eureka负载均衡调用
        long begin = System.currentTimeMillis();
        String url = "http://user-service/user/" + id;
        User forObject = restTemplate.getForObject(url, User.class);
        long end = System.currentTimeMillis();
        // 记录访问用时：
        logger.info("访问用时：{}", end - begin);
        return forObject;
    }
    public User queryUserByIdFallback(Long id){
        User user = new User();
        user.setId(id);
        user.setUsername("用户信息查询出现异常！");
        return user;
    }
}
