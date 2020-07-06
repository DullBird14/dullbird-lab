package org.dullbird.guava.demo.string;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年07月06日 20:46:00
 */
public class StringDemo {
    public static void main(String[] args) {
//        normalJointerDemo();
//        skipNullJoinerDemo();
//        replaceNullJoinerDemo();
        normalSplitterDemo();

    }
    private static Pattern compile = Pattern.compile("\\d");
    private static void normalSplitterDemo() {
        //利用char构造
        Splitter splitterByChar = Splitter.on(',');
        // 利用字符串构造
        Splitter splitterByString = Splitter.on(",");
        // 利用正则表达式构造
        Splitter splitterByRegex = Splitter.on(compile);
        Splitter splitter = splitterByRegex
                //移除字符前后的空白。可以是指定的字符
                .trimResults()
                //忽略空白
                .omitEmptyStrings()
                //切割的上限
                .limit(3);
        List<String> strings = splitter.splitToList(" a1b2c4 ");
        // [a, b, c4] 由于切割上限是3
        System.out.println(strings);
        splitter = splitterByRegex
                //移除字符前后的空白。可以是指定的字符
                .trimResults()
                //忽略空白
//                .omitEmptyStrings()
                //切割的上限
                .limit(10);
        strings = splitter.splitToList(" a1b2c4 ");
        // 设置上限，关闭忽略空白 [a, b, c, ]
        System.out.println(strings);

    }

    private static void replaceNullJoinerDemo() {
        //如果碰见null就替换成hahah
        Joiner joiner = Joiner.on(',').useForNull("hahah");
        String join = joiner.join("a", null, "b");
        //a,hahah,b
        System.out.println(join);
    }

    private static void normalJointerDemo() {
        try {
            Joiner joiner = Joiner.on(',');
            //普通操作，最终会调用对象的toString
            String join = joiner.join("a", "b", new User("张三", 10));
            //a,b,StringDemo.User(name=张三, age=10)
            System.out.println(join);
            // java.lang.NullPointerException
            join = joiner.join("a", null, 1);
            //a,b,StringDemo.User(name=张三, age=10)
            System.out.println(join);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void skipNullJoinerDemo() {
        //跳过null的值
        String join;
        Joiner skipNulls = Joiner.on(',').skipNulls();
        join = skipNulls.join("a", null, 1);
        //a,1
        System.out.println(join);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class User {
        private String name;
        private Integer age;

    }
}
