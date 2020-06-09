package org.dullbird.jdbc.demo.service;

import org.dullbird.jdbc.demo.StartApplication;
import org.dullbird.jdbc.demo.po.OrderDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年06月08日 22:14:00
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartApplication.class)
public class OrderServiceImplTest {
    @Autowired
    private OrderServiceImpl orderService;
    @Test
    public void add() {
        orderService.add(new OrderDO(111L,111));
    }

    @Test
    public void findById() {
        orderService.findById(110);
    }
}