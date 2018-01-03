package com.dan.sell.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * 类目表
 */
@Entity
@DynamicUpdate
@Table(uniqueConstraints = {@UniqueConstraint(name = "uqe_category_type", columnNames = "categoryType")})
public class ProductCategory {

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    public ProductCategory() {

    }

    /** 类目id */
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer categoryId;

    /** 类目名字 */
    @Column(columnDefinition = "VARCHAR(64) NOT NULL COMMENT '类目名字'")
    private String categoryName;

    /** 类目编号 */
    @Column(columnDefinition = "INT NOT NULL COMMENT '类目编号'")
    private Integer categoryType;

    /** 创建时间 */
    @Column(updatable = false, columnDefinition = "TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间'")
    private Date createTime;

    /** 更新时间 */
    @Column(columnDefinition = "TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '修改时间'")
    private Date updateTime;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    @Override
    public String toString() {
        return "ProductCategory{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryType=" + categoryType +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
