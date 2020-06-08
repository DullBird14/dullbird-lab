package org.dullbird.jdbc.demo.po;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年06月07日 23:53:00
 */
public class OrderDO {
    /**
     * 订单编号
     */
    private Long id;
    /**
     * 用户编号
     */
    private Integer userId;

    public OrderDO(Long id, Integer userId) {
        this.id = id;
        this.userId = userId;
    }

    public OrderDO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "OrderDO{" +
                "id=" + id +
                ", userId=" + userId +
                '}';
    }
}
