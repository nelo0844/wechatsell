package com.dan.sell.service.impl;

import com.dan.sell.entity.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceimplTest {

    @Autowired
    private ProductInfoServiceimpl productInfoServiceimpl;

    @Test
    public void findOne() {
//        ProductInfo productInfo = productInfoServiceimpl.findOne();
    }

    @Test
    public void findUpAll() {
    }

    @Test
    public void findAll() {
        PageRequest pageRequest = new PageRequest(0,2);
        Page<ProductInfo> productInfoPage = productInfoServiceimpl.findAll(pageRequest);
        System.out.println(productInfoPage.getTotalElements());
     }

    @Test
    public void save() {
    }

    private void beforeTest(){

    }
}