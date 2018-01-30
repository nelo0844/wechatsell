package com.dan.sell.utils;

import com.dan.sell.enums.CodeEnum;
import com.dan.sell.enums.OrderStatusEnum;

public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){
        for (T each: enumClass.getEnumConstants()){
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
