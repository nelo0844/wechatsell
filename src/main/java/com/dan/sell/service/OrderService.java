package com.dan.sell.service;

import com.dan.sell.dto.OrderDto;
import com.dan.sell.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {

    /** 创建订单 */
    OrderDto Create(OrderDto orderDto);

    /** 查询单个订单 */
    OrderDto findOne(String orderId);

    /** 查询订单列表 */
    Page<OrderDto> findList(String buyerOpenid, Pageable pageable);

    /** 取消订单 */
    OrderDto cancel(OrderDto orderDto);

    /** 完结订单 */
    OrderDto finish(OrderDto orderDto);

    /** 支付订单 */
    OrderDto paid(OrderDto orderDto);
}