package org.dullbird.cloud.dubbo.demo.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.dullbird.cloud.dubbo.api.UserService;
import org.dullbird.cloud.dubbo.demo.feign.UserFeignClient;
import org.dullbird.cloud.dubbo.dto.UserAddDTO;
import org.dullbird.cloud.dubbo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月18日 20:26:00
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserFeignClient client;

    @GetMapping("/get")
    public UserDTO get(@RequestParam("id") Integer id) {
        return client.get(id);
    }

    @PostMapping("/add")
    public Integer add(UserAddDTO addDTO) {
        return client.add(addDTO);
    }

}
