package org.dullbird.mybatis.plus.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.dullbird.mybatis.plus.demo.po.User;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月08日 23:34:00
 */
public interface UserMapper extends BaseMapper<User> {


    User getUserByAge(@Param("age") Integer age);

    /**
     * 如果有重复名字的字段。会取第一个
     * @param age
     * @return
     */
    User getUserByAgeAlias(@Param("age") Integer age);
}
