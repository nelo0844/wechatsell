package com.dan.sell.service.impl;

import com.dan.sell.entity.ProductCategory;
import com.dan.sell.util.ProductTestBefore;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class productCategoryServiceImplTest {

    private List<Integer> productCategoryIdList;

    @Autowired
    private ProductCategoryServiceImpl productCategoryService;

    @Test
    public void findOne() {
        List<Integer> categoryIdList = new ProductTestBefore().beforeTest(productCategoryService);
        ProductCategory productCategory = productCategoryService.findOne(categoryIdList.get(0));
        Assert.assertNotNull(productCategory);
    }

    @Test
    public void findAll() {
        new ProductTestBefore().beforeTest(productCategoryService);
        List<ProductCategory> productCategoryList = productCategoryService.findAll();
        Assert.assertNotNull(productCategoryList);
    }

    @Test
    public void findByCategoryTypeIn() {
        ProductTestBefore productTestBefore = new ProductTestBefore();
        productTestBefore.beforeTest(productCategoryService);
        List categoryTypeList = new ArrayList();
        categoryTypeList.add(productTestBefore.getProductCategoryType1());
        categoryTypeList.add(productTestBefore.getProductCategoryType2());
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);
        Assert.assertNotNull(productCategoryList);
    }

    @Test
    public void save() {
        ProductTestBefore productTestBefore = new ProductTestBefore();
        ProductCategory productCategory =
                productCategoryService.save(new ProductCategory(productTestBefore.getProductCategoryName1(), productTestBefore.getProductCategoryType1()));
        Assert.assertNotNull(productCategory);
    }
}