import org.dullbird.mybatis.plus.demo.MybatisPlusApplicationDemo;
import org.dullbird.mybatis.plus.demo.mapper.SelfMapper;
import org.dullbird.mybatis.plus.demo.mapper.UserMapper;
import org.dullbird.mybatis.plus.demo.po.User;
import org.dullbird.mybatis.plus.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月08日 23:35:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisPlusApplicationDemo.class)
public class SampleTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @Resource
    private SelfMapper selfMapper;

    @Test
    public void testSelect() {
//        System.out.println(("----- selectAll method test ------"));
//        List<User> userList = userMapper.selectList(null);
//        Assert.assertEquals(5, userList.size());
//        userList.forEach(System.out::println);
//        System.out.println("===============================");
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.likeLeft("name", "Tom");
//        List<User> users = userMapper.selectList(queryWrapper);
//        users.forEach(System.out::println);
        User userByAge = userMapper.getUserByAge(28);
        System.out.println(userByAge);
        User userByAgeAlias = userMapper.getUserByAgeAlias(28);
        System.out.println(userByAgeAlias);

    }

    @Test
    public void testConditionSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userService.list();
        userList.forEach(System.out::println);
    }
    @Test
    public void testA() {
        int i = userMapper.deleteById(5L);
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
}