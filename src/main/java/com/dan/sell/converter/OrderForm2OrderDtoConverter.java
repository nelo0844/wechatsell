package com.dan.sell.converter;

import com.dan.sell.dto.OrderDto;
import com.dan.sell.form.OrderForm;

public class OrderForm2OrderDtoConverter {

    public static OrderDto convert (OrderForm orderForm){
        OrderDto orderDto = new OrderDto();
        orderDto.setBuyerName(orderForm.getName());
        orderDto.setBuyerPhone(orderForm.getPhone());
        orderDto.setBuyerAddress(orderForm.getAddress());
        orderDto.setBuyerOpenid(orderForm.getOpenid());
        orderDto.setOrderDetailList(orderForm.getItems());
        return orderDto;
    }
}
