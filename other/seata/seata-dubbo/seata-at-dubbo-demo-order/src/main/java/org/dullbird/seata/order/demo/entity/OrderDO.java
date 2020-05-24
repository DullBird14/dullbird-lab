package org.dullbird.seata.order.demo.entity;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年05月24日 13:32:00
 */
public class OrderDO {

    /** 订单编号 **/
    private Integer id;

    /** 用户编号 **/
    private Long userId;

    /** 产品编号 **/
    private Long productId;

    /** 支付金额 **/
    private Integer payAmount;

    public Integer getId() {
        return id;
    }

    public OrderDO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public OrderDO setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getProductId() {
        return productId;
    }

    public OrderDO setProductId(Long productId) {
        this.productId = productId;
        return this;
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public OrderDO setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
        return this;
    }

    @Override
    public String toString() {
        return "OrderDO{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                ", payAmount=" + payAmount +
                '}';
    }
}
