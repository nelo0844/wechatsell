package com.dan.sell.enums;

/**
 * 商品状态
 */
public enum ProductStatusEnum {

    UP(0, "上架"),
    DOWN(1, "下架")
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }

}