package org.dullbird.seata.demo.service;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年05月22日 23:28:00
 */
public interface StorageService {
    /**
     * deduct storage count
     */
    void deduct(String commodityCode, int count);
}
