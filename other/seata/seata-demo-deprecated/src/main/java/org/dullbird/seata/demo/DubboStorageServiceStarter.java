package org.dullbird.seata.demo;

import org.dullbird.seata.demo.service.StorageService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.concurrent.CountDownLatch;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年05月22日 22:51:00
 */
public class DubboStorageServiceStarter {
    /**
     * 1. Storage service is ready . A seller add 100 storage to a sku: C00321
     *
     * @param args the input arguments
     */
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);

        ClassPathXmlApplicationContext storageContext = new ClassPathXmlApplicationContext(
                new String[] {"spring/dubbo-storage-service.xml"});
        StorageService service = storageContext.getBean("service", StorageService.class);
        JdbcTemplate storageJdbcTemplate = (JdbcTemplate)storageContext.getBean("jdbcTemplate");
        storageJdbcTemplate.update("delete from storage_tbl where commodity_code = 'C00321'");
        storageJdbcTemplate.update("insert into storage_tbl(commodity_code, count) values ('C00321', 100)");
        service.deduct("C00321", 2);
        System.out.println("==================start success====================");
        latch.await();
    }
}
