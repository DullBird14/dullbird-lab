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

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年06月08日 00:05:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartApplication.class)
public class OrderConfigMapperTest {

    @Autowired
    private OrderConfigMapper orderConfigMapper;

    @Test
    public void testSelectById() {
        OrderConfigDO orderConfig = orderConfigMapper.selectById(1);
        System.out.println(orderConfig);
    }

}
