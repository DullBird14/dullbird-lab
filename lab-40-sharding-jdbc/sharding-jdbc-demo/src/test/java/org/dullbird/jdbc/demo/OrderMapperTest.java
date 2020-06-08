package org.dullbird.jdbc.demo;

import org.dullbird.jdbc.demo.mapper.OrderConfigMapper;
import org.dullbird.jdbc.demo.mapper.OrderMapper;
import org.dullbird.jdbc.demo.po.OrderConfigDO;
import org.dullbird.jdbc.demo.po.OrderDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年06月08日 00:05:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartApplication.class)
public class OrderMapperTest {
    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void testSelectById() {
        OrderDO order = orderMapper.selectById(1);
        System.out.println(order);
    }

    @Test
    public void testSelectListByUserId() {
        List<OrderDO> orders = orderMapper.selectListByUserId(1);
        System.out.println(orders.size());
    }

    @Test
    public void testInsert() {
        OrderDO order = new OrderDO();
        order.setUserId(1);
        orderMapper.insert(order);
    }

}
