package org.dullbird.seata.demo.service;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年05月22日 23:29:00
 */
public interface AccountService {
    /**
     * debit balance of user's account
     */
    void debit(String userId, int money);
}
