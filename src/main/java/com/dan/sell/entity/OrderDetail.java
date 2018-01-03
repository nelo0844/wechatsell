package com.dan.sell.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@DynamicUpdate
@Table(indexes = @Index(columnList = ("orderId"),name="idx_order_id",unique=false))
public class OrderDetail {

    @Id
    @Column(length = 32, nullable = false)
    private String detailId;

    /** 订单id */
    @Column(length = 32, nullable = false)
    private String orderId;

    /** 商品id */
    @Column(length = 32, nullable = false)
    private String productId;

    /** 商品名称 */
    @Column(length = 64, nullable = false)
    private String productName;

    /** 商品单价 */
    @Column(columnDefinition = "decimal(8,2) not null comment '当前价格,单位分'")
    private BigDecimal productPrice;

    /** 商品数量 */
    @Column(nullable = false)
    private Integer productQuantity;

    /** 商品小图 */
    @Column(length = 512, nullable = false)
    private String productIcon;

    /** 创建时间 */
    @Column(updatable = false, columnDefinition = "TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间'")
    private Date createTime;

    /** 更新时间 */
    @Column(columnDefinition = "TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '修改时间'")
    private Date updateTime;

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductIcon() {
        return productIcon;
    }

    public void setProductIcon(String productIcon) {
        this.productIcon = productIcon;
    }
}
