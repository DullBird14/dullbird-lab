package org.dullbird.jdbc.demo.service;

import org.dullbird.jdbc.demo.mapper.OrderMapper;
import org.dullbird.jdbc.demo.po.OrderDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年06月08日 22:09:00
 */
@Service
public class OrderServiceImpl {
    @Autowired
    private OrderMapper orderMapper;
    @Transactional(rollbackFor = Exception.class)
    public void add(OrderDO order){
        //查询从库
        OrderDO orderDO = orderMapper.selectById(1);
        System.out.println(orderDO);
        // 插入数据
        int insert = orderMapper.insert(order);
        System.out.println(insert);
        // 读取。会读取主库
        OrderDO orderDO1 = orderMapper.selectById(order.getId());
        System.out.println(orderDO1);

    }


    public void findById(Integer id){
        OrderDO orderDO = orderMapper.selectById(id);
        System.out.println(orderDO);
    }
}
