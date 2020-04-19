package org.dullbird.cloud.dubbo.demo.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.dullbird.cloud.dubbo.api.UserService;
import org.dullbird.cloud.dubbo.dto.UserAddDTO;
import org.dullbird.cloud.dubbo.dto.UserDTO;
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
    @Reference(version = "1.0.0")
    private UserService userService;

    @GetMapping("/get")
    public UserDTO get(@RequestParam("id") Integer id) {
        return userService.get(id);
    }

    @PostMapping("/add")
    public Integer add(UserAddDTO addDTO) {
        return userService.add(addDTO);
    }

}
