package com.dan.sell.repository;

import com.dan.sell.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory = repository.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    @Transactional
    public void saveTest(){

        ProductCategory productCategory = repository.findOne(8);

//        ProductCategory productCategory = new ProductCategory();
//        productCategory.setCategoryId(8);
//        productCategory.setCategoryName("测试3");
        productCategory.setCategoryType(32);
//        productCategory.setCreateTime(new Date());
                ProductCategory productCategory2 = repository.save(productCategory);
//        System.out.println(productCategory2);
        Assert.assertNotNull(productCategory2);
    }

    @Test
    @Transactional
    public void findByCategoryTypeInTest(){
        //增加测试数据
        ProductCategory productCategory1 = new ProductCategory();
        productCategory1.setCategoryName("测试1");
        productCategory1.setCategoryType(98);
        repository.save(productCategory1);

        ProductCategory productCategory2 = new ProductCategory();
        productCategory2.setCategoryName("测试2");
        productCategory2.setCategoryType(99);
        repository.save(productCategory2);

        List<Integer> categoryTyleList = new ArrayList<>();
        categoryTyleList.add(98);
        categoryTyleList.add(99);
        List<ProductCategory> productCategoryList = repository.findByCategoryTypeIn(categoryTyleList);
        Assert.assertEquals(2, productCategoryList.size());
    }
}