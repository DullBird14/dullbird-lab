package org.dullbird.cloud.dubbo.demo.service;

import org.dullbird.cloud.dubbo.api.UserService;
import org.dullbird.cloud.dubbo.dto.UserAddDTO;
import org.dullbird.cloud.dubbo.dto.UserDTO;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.Random;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月18日 20:03:00
 */
//@Service
@org.apache.dubbo.config.annotation.Service(protocol = {"dubbo", "rest"}, version = "1.0.0")
@Path("/user")
public class UserServiceImpl implements UserService {
    private static Random random = new Random();
    @Override
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO get(Integer id) {
        UserDTO userDTO = new UserDTO();
        userDTO.setGender(id % 2 + 1);
        userDTO.setName("陈" + id);
        userDTO.setId(id);
        return userDTO;
    }

    @Override
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Integer add(UserAddDTO addDTO) {
        return random.nextInt();
    }
}