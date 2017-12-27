package com.dan.sell.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 类目表
 */
@Entity
public class ProductCategory {

    /** 类目id */
    @Id
    @GeneratedValue
    private Integer categoryId;

    /** 类目名字 */
    private String categoryName;

    /** 类目编号 */
    private Integer categoryType;

    /** 创建时间 */

    private Date createTime;

    /** 更新时间 */
    private Date updateTimel;

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

    public Date getUpdateTimel() {
        return updateTimel;
    }

    public void setUpdateTimel(Date updateTimel) {
        this.updateTimel = updateTimel;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryType=" + categoryType +
                '}';
    }
}
