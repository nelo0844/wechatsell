package com.dan.sell.controller;

import com.dan.sell.dto.ProductDto;
import com.dan.sell.dto.ProductInfoDto;
import com.dan.sell.dto.ResultDto;
import com.dan.sell.entity.ProductCategory;
import com.dan.sell.entity.ProductInfo;
import com.dan.sell.service.ProductInfoService;
import com.dan.sell.service.productCategoryService;
import com.dan.sell.utils.ResultDtoUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private productCategoryService productCategoryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultDto list(){
        //1. 查询所有的上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();

        //2. 查询类目(一次性查询)
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);

        //3. 数据拼装
        List<ProductDto> productDtoList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductDto productDto = new ProductDto();
            productDto.setCategoryType(productCategory.getCategoryType());
            productDto.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoDto> productInfoDtoList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoDto productInfoDto = new ProductInfoDto();
//                    productInfoDto.setProductId(productInfo.getProductId());
//                    productInfoDto.setProductName(productInfo.getProductName());
//                    productInfoDto.setProductDescription(productInfo.getProductDescription());
//                    productInfoDto.setProductPrice(productInfo.getProductPrice());
//                    productInfoDto.setProductIcon(productInfo.getProductIcon());
                    BeanUtils.copyProperties(productInfo, productInfoDto);
                    productInfoDtoList.add(productInfoDto);
                }
            }
            productDto.setProductInfoDtoList(productInfoDtoList);
            productDtoList.add(productDto);
        }

//        ResultDto resultDto = new ResultDto();
//        resultDto.setCode(0);
//        resultDto.setMsg("成功");
//        resultDto.setData(productDtoList);

        return ResultDtoUtil.success(productDtoList);
    }
}
