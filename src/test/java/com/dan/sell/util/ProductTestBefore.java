package com.dan.sell.util;

import com.dan.sell.entity.ProductCategory;
import com.dan.sell.service.impl.ProductCategoryServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest
@Transactional
public class ProductTestBefore {

    private String productCategoryName1 = "测试1";
    private String productCategoryName2 = "测试2";
    private Integer productCategoryType1 = 98;
    private Integer productCategoryType2 = 99;
    private List<Integer> productCategoryIdList;

//    @Autowired
//    private ProductCategoryServiceImpl productCategoryService;

    public List beforeTest(ProductCategoryServiceImpl productCategoryService){
        List<Integer> categoryIdList = new ArrayList<>();
        ProductCategory productCategory1 =
                productCategoryService.save(new ProductCategory(productCategoryName1, productCategoryType1));
        categoryIdList.add(productCategory1.getCategoryId());

        ProductCategory productCategory2 =
                productCategoryService.save(new ProductCategory(productCategoryName2, productCategoryType2));
        categoryIdList.add(productCategory2.getCategoryId());

        return categoryIdList;
    }

    public String getProductCategoryName1() {
        return productCategoryName1;
    }

    public String getProductCategoryName2() {
        return productCategoryName2;
    }

    public Integer getProductCategoryType1() {
        return productCategoryType1;
    }

    public Integer getProductCategoryType2() {
        return productCategoryType2;
    }
}
