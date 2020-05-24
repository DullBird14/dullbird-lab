package org.dullbird.seata.product.demo.service;

import io.seata.core.context.RootContext;
import org.dullbird.seata.demo.product.api.ProductService;
import org.dullbird.seata.product.demo.dao.ProductDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年05月24日 13:20:00
 */
@org.apache.dubbo.config.annotation.Service
public class ProductServiceImpl implements ProductService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ProductDao productDao;

    @Override
    @Transactional // <1> 开启新事物
    public void reduceStock(Long productId, Integer amount) throws Exception {
        logger.info("[reduceStock] 当前 XID: {}", RootContext.getXID());

        // <2> 检查库存
        checkStock(productId, amount);

        logger.info("[reduceStock] 开始扣减 {} 库存", productId);
        // <3> 扣减库存
        int updateCount = productDao.reduceStock(productId, amount);
        // 扣除成功
        if (updateCount == 0) {
            logger.warn("[reduceStock] 扣除 {} 库存失败", productId);
            throw new Exception("库存不足");
        }
        // 扣除失败
        logger.info("[reduceStock] 扣除 {} 库存成功", productId);
    }

    private void checkStock(Long productId, Integer requiredAmount) throws Exception {
        logger.info("[checkStock] 检查 {} 库存", productId);
        Integer stock = productDao.getStock(productId);
        if (stock < requiredAmount) {
            logger.warn("[checkStock] {} 库存不足，当前库存: {}", productId, stock);
            throw new Exception("库存不足");
        }
    }

}
