package com.dan.sell.repository;

import com.dan.sell.entity.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    private final String ORDERID = "12345";

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("10002");
        orderDetail.setOrderId(ORDERID);
        orderDetail.setProductId("P_00002");
        orderDetail.setProductName("沙冰");
        orderDetail.setProductPrice(new BigDecimal(0.02));
        orderDetail.setProductQuantity(1);
        orderDetail.setProductIcon("http://abc.com");

        OrderDetail result = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() {
        PageRequest pageRequest = new PageRequest(0,1);
        List<OrderDetail> result = orderDetailRepository.findByOrderId(ORDERID, pageRequest);
        Assert.assertNotNull(result);
    }
}