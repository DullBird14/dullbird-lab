package org.dullbird.log.demo.b;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PathBLogDemo {
    private static final Logger logger = LoggerFactory.getLogger(PathBLogDemo.class);

    public void test() {
        logger.info("B:测试是否输出日志！！！");
        logger.debug("B:debug:测试是否输出日志！！！");
        System.out.println("B:===============");
    }
}
