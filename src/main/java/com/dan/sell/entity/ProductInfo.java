package com.dan.sell.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品
 */
@Entity
@DynamicUpdate
public class ProductInfo {

    @Id
    @Column(columnDefinition = "VARCHAR(32) NOT NULL")
    private String productId;

    /** 商品名称 */
    @Column(columnDefinition = "VARCHAR(64) NOT NULL COMMENT '商品名称'")
    private String productName;

    /** 商品单价 */
    @Column(columnDefinition = "DECIMAL(8,2) NOT NULL COMMENT'商品单价'")
    private BigDecimal productPrice;

    /** 商品库存 */
    @Column(columnDefinition = "INT NOT NULL COMMENT'商品库存'")
    private Integer productStock;

    /** 商品描述 */
    @Column(columnDefinition = "VARCHAR(512) NOT NULL COMMENT '商品描述'")
    private String productDescription;

    /** 商品小图 */
    @Column(columnDefinition = "VARCHAR(512) DEFAULT NULL COMMENT '商品小图'")
    private String productIcon;

    /** 商品状态, 0正常，1下架*/
    @Column(columnDefinition = "TINYINT(3) DEFAULT '0' COMMENT '商品状态，0正常，1下架'")
    private Integer productStatus;

    /** 类目编号 */
    @Column(columnDefinition = "INT NOT NULL COMMENT '类目编号'")
    private Integer categoryType;

    /** 创建时间 */
    @Column(updatable = false, columnDefinition = "TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间'")
    private Date createTime;

    /** 更新时间 */
    @Column(columnDefinition = "TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '修改时间'")
    private Date updateTime;

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

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductIcon() {
        return productIcon;
    }

    public void setProductIcon(String productIcon) {
        this.productIcon = productIcon;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }
}
