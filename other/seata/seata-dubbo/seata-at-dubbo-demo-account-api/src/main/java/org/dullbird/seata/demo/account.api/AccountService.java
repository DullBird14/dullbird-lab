package org.dullbird.seata.demo.account.api;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年05月24日 15:34:00
 */
public interface AccountService {
    void reduceBalance(Long userId, Integer price) throws Exception;
}
