package com.dan.sell.service;

import com.dan.sell.entity.ProductCategory;

import java.util.List;

/**
 * 类目
 */
public interface productCategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);

}
