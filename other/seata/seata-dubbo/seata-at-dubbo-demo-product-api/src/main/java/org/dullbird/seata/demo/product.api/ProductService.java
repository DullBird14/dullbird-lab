package org.dullbird.seata.demo.product.api;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年05月24日 15:34:00
 */
public interface ProductService {
    void reduceStock(Long productId, Integer amount) throws Exception;
}
