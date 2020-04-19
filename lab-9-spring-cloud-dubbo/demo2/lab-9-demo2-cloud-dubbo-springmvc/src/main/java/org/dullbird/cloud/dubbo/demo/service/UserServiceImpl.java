package org.dullbird.cloud.dubbo.demo.service;

import org.dullbird.cloud.dubbo.api.UserService;
import org.dullbird.cloud.dubbo.dto.UserAddDTO;
import org.dullbird.cloud.dubbo.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月18日 20:03:00
 */
//@Service
@org.apache.dubbo.config.annotation.Service(protocol = {"dubbo"}, version = "1.0.0")
@RestController
@RequestMapping("/user")
public class UserServiceImpl implements UserService {
    private static Random random = new Random();
    @Override
    @GetMapping("/get")
    public UserDTO get(Integer id) {
        UserDTO userDTO = new UserDTO();
        userDTO.setGender(id % 2 + 1);
        userDTO.setName("陈" + id);
        userDTO.setId(id);
        return userDTO;
    }

    @Override
    @PostMapping("/add")
    public Integer add(UserAddDTO addDTO) {
        return random.nextInt();
    }
}
