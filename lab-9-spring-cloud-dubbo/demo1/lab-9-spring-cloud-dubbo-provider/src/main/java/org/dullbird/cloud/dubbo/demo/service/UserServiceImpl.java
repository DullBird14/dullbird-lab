package org.dullbird.cloud.dubbo.demo.service;

import org.dullbird.cloud.dubbo.api.UserService;
import org.dullbird.cloud.dubbo.dto.UserAddDTO;
import org.dullbird.cloud.dubbo.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月18日 20:03:00
 */
@Service
@org.apache.dubbo.config.annotation.Service(protocol = "dubbo", version = "1.0.0")
public class UserServiceImpl implements UserService {
    private static Random random = new Random();
    @Override
    public UserDTO get(Integer id) {
        UserDTO userDTO = new UserDTO();
        userDTO.setGender(id % 2 + 1);
        userDTO.setName("陈" + id);
        userDTO.setId(id);
        return userDTO;
    }

    @Override
    public Integer add(UserAddDTO addDTO) {
        return random.nextInt();
    }
}
