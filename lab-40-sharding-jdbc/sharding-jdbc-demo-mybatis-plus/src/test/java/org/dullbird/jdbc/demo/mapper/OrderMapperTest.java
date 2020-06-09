package org.dullbird.jdbc.demo.mapper;

import org.apache.shardingsphere.api.hint.HintManager;
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
        for (int i = 0; i < 2; i++) {
            OrderDO order = orderMapper.selectById(1);
            System.out.println(order);
        }
    }
    @Test
    public void testSelectById02() { // 测试强制访问主库
        try (HintManager hintManager = HintManager.getInstance()) {
            // 设置强制访问主库
            hintManager.setMasterRouteOnly();
            // 执行查询
            OrderDO order = orderMapper.selectById(1);
            System.out.println(order);
        }
    }
    @Test
    public void testAdd() {
        int insert = orderMapper.insert(new OrderDO(5L, 5));
        System.out.println(insert);
    }
}