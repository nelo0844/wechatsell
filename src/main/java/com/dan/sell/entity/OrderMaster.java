package com.dan.sell.entity;

import com.dan.sell.enums.OrderStatusEnum;
import com.dan.sell.enums.PayStatusEnum;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@DynamicUpdate
@Table(indexes = @Index(columnList = ("buyerOpenid"),name="idx_buyer_openid",unique=false))
public class OrderMaster {

    /** 订单id */
    @Id
    @Column(columnDefinition = "varchar(32) not null")
    private String orderId;

    /** 买家名字 */
    @Column(columnDefinition = "varchar(32) not null comment '买家名字'")
    private String buyerName;

    /** 买家电话 */
    @Column(columnDefinition = "varchar(32) not null comment '买家电话'")
    private String buyerPhone;

    /** 买家地址 */
    @Column(columnDefinition = "varchar(128) not null comment '买家地址'")
    private String buyerAddress;

    /** 买家微信Openid */
    @Column(columnDefinition = "varchar(64) not null comment '买家微信openid'")
    private String buyerOpenid;

    /** 订单总金额 */
    @Column(columnDefinition = "decimal(8,2) not null comment '订单总金额'")
    private BigDecimal orderAmount;

    /** 订单状态，默认为0新下单 */
    @Column(columnDefinition = "tinyint(3) not null default '0' comment '订单状态, 默认为新下单'")
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态，默认为0未支付 */
    @Column(columnDefinition = "tinyint(3) not null default '0' comment '支付状态, 默认未支付'")
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 创建时间 */
    @Column(columnDefinition = "timestamp not null default current_timestamp comment '创建时间'")
    private Date createTime;

    /** 更新时间 */
    @Column(columnDefinition = "timestamp not null default current_timestamp on update current_timestamp comment '修改时间'")
    private Date updateTime;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    public String getBuyerOpenid() {
        return buyerOpenid;
    }

    public void setBuyerOpenid(String buyerOpenid) {
        this.buyerOpenid = buyerOpenid;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }
}
