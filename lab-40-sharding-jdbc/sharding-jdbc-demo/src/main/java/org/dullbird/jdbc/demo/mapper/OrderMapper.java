package org.dullbird.jdbc.demo.mapper;

import org.apache.ibatis.annotations.Param;
import org.dullbird.jdbc.demo.po.OrderDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年06月08日 00:01:00
 */
@Repository
public interface OrderMapper {
//    OrderDO selectById(@Param("id") Integer id);
//    List<OrderDO> selectListByUserId(@Param("userId") Integer userId);
//    void insert(@Param("order") OrderDO order);
    int insert(@Param("order") OrderDO orderDO);
}
