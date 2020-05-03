package org.dullbird.mybatis.plus.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dullbird.mybatis.plus.demo.mapper.UserMapper;
import org.dullbird.mybatis.plus.demo.po.User;
import org.springframework.stereotype.Service;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月27日 22:11:00
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
