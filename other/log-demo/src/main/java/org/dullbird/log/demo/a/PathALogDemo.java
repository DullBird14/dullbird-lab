package org.dullbird.log.demo.a;

import org.dullbird.log.demo.b.PathBLogDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PathALogDemo {
    private static final Logger logger = LoggerFactory.getLogger(PathALogDemo.class);

    public static void main(String[] args) {
        logger.info("测试是否输出日志！！！");
        logger.debug("debug:测试是否输出日志！！！");
        System.out.println("===============");
        PathBLogDemo pathBLogDemo = new PathBLogDemo();
        pathBLogDemo.test();
    }
}
