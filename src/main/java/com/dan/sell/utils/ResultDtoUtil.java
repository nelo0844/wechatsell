package com.dan.sell.utils;

import com.dan.sell.dto.ResultDto;

public class ResultDtoUtil {

    public static ResultDto success(Object object){
        ResultDto resultDto = new ResultDto();
        resultDto.setData(object);
        resultDto.setCode(0);
        resultDto.setMsg("成功");
        return resultDto;
    }

    public static ResultDto success(){
        return success(null);
    }

    public static ResultDto error(Integer code, String msg){
        ResultDto resultDto = new ResultDto();
        resultDto.setCode(code);
        resultDto.setMsg(msg);
        return resultDto;
    }
}
