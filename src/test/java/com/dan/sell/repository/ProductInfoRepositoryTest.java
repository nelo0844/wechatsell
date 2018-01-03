package com.dan.sell.repository;

import com.dan.sell.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    @Transactional
    public void findByProductStatus() {
        ProductInfo productInfo1 = new ProductInfo();
        productInfo1.setProductId("P_00001");
        productInfo1.setCategoryType(98);
        productInfo1.setProductDescription("很好喝的皮蛋瘦肉粥");
        productInfo1.setProductIcon("http://abc.com");
        productInfo1.setProductName("皮蛋瘦肉粥");
        productInfo1.setProductPrice(new BigDecimal(0.01));
        productInfo1.setProductStock(100);
        productInfo1.setProductStatus(0);
        productInfoRepository.save(productInfo1);

        ProductInfo productInfo2 = new ProductInfo();
        productInfo2.setProductId("P_00002");
        productInfo2.setCategoryType(99);
        productInfo2.setProductDescription("很好喝的沙冰");
        productInfo2.setProductIcon("http://abcd.com");
        productInfo2.setProductName("沙冰");
        productInfo2.setProductPrice(new BigDecimal(0.02));
        productInfo2.setProductStock(50);
        productInfo2.setProductStatus(1);
        productInfoRepository.save(productInfo2);

        List<ProductInfo> productInfoList = productInfoRepository.findByProductStatus(0);
        Assert.assertNotNull(productInfoList);
    }
}