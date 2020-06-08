package org.dullbird.jdbc.demo.mapper;

import org.dullbird.jdbc.demo.StartApplication;
import org.dullbird.jdbc.demo.po.OrderDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年06月08日 21:23:00
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartApplication.class)
public class OrderMapperTest {
    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void test1() {
        orderMapper.insert(new OrderDO(1L, 1));
    }

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
}