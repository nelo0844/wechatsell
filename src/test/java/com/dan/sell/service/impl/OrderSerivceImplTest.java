package com.dan.sell.service.impl;

import com.dan.sell.dto.OrderDto;
import com.dan.sell.entity.OrderDetail;
import com.dan.sell.enums.OrderStatusEnum;
import com.dan.sell.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderSerivceImplTest {

    @Autowired
    private OrderSerivceImpl orderSerivce;

    private final String BUYEROPENID = "100101";

    private final String ORDER_ID = "1515046652673977660";

    @Test
    @Transactional
    public void create() {
        OrderDto orderDto = new OrderDto();
        orderDto.setBuyerName("老司机");
        orderDto.setBuyerAddress("软件园");
        orderDto.setBuyerPhone("12345678901");
        orderDto.setBuyerOpenid(BUYEROPENID);

        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setProductId("P_00001");
        orderDetail1.setProductQuantity(2);
        orderDetailList.add(orderDetail1);

        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setProductId("P_00002");
        orderDetail2.setProductQuantity(1);
        orderDetailList.add(orderDetail2);

        orderDto.setOrderDetailList(orderDetailList);
        OrderDto result = orderSerivce.Create(orderDto);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
        OrderDto orderDto = orderSerivce.findOne(ORDER_ID);
        Assert.assertNotNull(orderDto);
        System.out.println(orderDto);
    }

    @Test
    public void findList() {
        PageRequest pageRequest = new PageRequest(0,3);
        Page<OrderDto> orderDtoPage = orderSerivce.findList(BUYEROPENID, pageRequest);
        Assert.assertNotEquals(0,orderDtoPage.getTotalElements());
    }

    @Test
    @Transactional
    public void cancel() {
        OrderDto orderDto = orderSerivce.findOne(ORDER_ID);
        OrderDto result = orderSerivce.cancel(orderDto);
        Assert.assertEquals(ORDER_ID,result.getOrderId());
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),result.getOrderStatus());
    }

    @Test
    @Transactional
    public void finish() {
        OrderDto orderDto = orderSerivce.findOne(ORDER_ID);
        OrderDto result = orderSerivce.finish(orderDto);
        Assert.assertEquals(ORDER_ID,result.getOrderId());
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),result.getOrderStatus());
    }

    @Test
    @Transactional
    public void paid() {
        OrderDto orderDto = orderSerivce.findOne(ORDER_ID);
        OrderDto result = orderSerivce.paid(orderDto);
        Assert.assertEquals(ORDER_ID,result.getOrderId());
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());
    }
}