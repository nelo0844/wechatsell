package com.dan.sell.service;

import com.dan.sell.dto.OrderDto;
import com.dan.sell.enums.ResultEnum;
import com.dan.sell.exception.SellException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDto findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid, orderId);
    }

    @Override
    public OrderDto cancelOrder(String openid, String orderId) {
        OrderDto orderDto = checkOrderOwner(openid, orderId);
        if (orderDto == null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDto);
    }

    private OrderDto checkOrderOwner(String openid, String orderId){
        OrderDto orderDto = orderService.findOne(orderId);
        if (orderDto == null){
            return null;
        }
        //判断是否是自己的订单
        if (!orderDto.getBuyerOpenid().equals(openid)){
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDto;
    }
}
