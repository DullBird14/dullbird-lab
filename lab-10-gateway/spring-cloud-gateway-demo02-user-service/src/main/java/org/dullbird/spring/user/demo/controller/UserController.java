package org.dullbird.spring.user.demo.controller;

import org.dullbird.spring.user.demo.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年05月28日 23:50:00
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping
    public Object getUser(@RequestParam Long userId) {
        return new User(userId, null, "zhangsan");
    }
}
