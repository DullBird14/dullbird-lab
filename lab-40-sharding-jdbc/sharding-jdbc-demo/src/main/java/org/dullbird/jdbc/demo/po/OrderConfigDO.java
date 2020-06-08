package org.dullbird.jdbc.demo.po;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年06月07日 23:53:00
 */
public class OrderConfigDO {
    /**
     * 编号
     */
    private Integer id;
    /**
     * 支付超时时间
     *
     * 单位：分钟
     */
    private Integer payTimeout;

    @Override
    public String toString() {
        return "OrderConfigDO{" +
                "id=" + id +
                ", payTimeout=" + payTimeout +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPayTimeout() {
        return payTimeout;
    }

    public void setPayTimeout(Integer payTimeout) {
        this.payTimeout = payTimeout;
    }
}
