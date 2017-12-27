package com.dan.sell.repository;

import com.dan.sell.entity.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory();
//        productCategory.setCategoryId(2);
        productCategory.setCategoryName("测试3");
        productCategory.setCategoryType(31);
        ProductCategory productCategory2 = repository.save(productCategory);
        System.out.println(productCategory2);
    }
}