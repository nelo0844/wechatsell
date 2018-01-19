package com.dan.sell.controller;

import com.dan.sell.converter.OrderForm2OrderDtoConverter;
import com.dan.sell.dto.OrderDto;
import com.dan.sell.dto.ResultDto;
import com.dan.sell.enums.ResultEnum;
import com.dan.sell.exception.SellException;
import com.dan.sell.form.OrderForm;
import com.dan.sell.service.BuyerService;
import com.dan.sell.service.OrderService;
import com.dan.sell.utils.ResultDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/buyer/order")
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    private BuyerService buyerService;

    //创建订单
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResultDto<Map<String,String>> create(@Valid @RequestBody OrderForm orderForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new SellException(ResultEnum.PARAM_ERROR,bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDto orderDto = OrderForm2OrderDtoConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDto.getOrderDetailList())){
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDto createResult = orderService.create(orderDto);
        Map<String,String> map = new HashMap<>();
        map.put("orderId",createResult.getOrderId());
        return ResultDtoUtil.success(map);
    }

    //订单列表
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResultDto<List<OrderDto>> list(@RequestParam("openid") String openid,
                                          @RequestParam(value = "page",defaultValue = "0") Integer page,
                                          @RequestParam(value = "size",defaultValue = "10") Integer size){
        if (StringUtils.isEmpty(openid)){
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest pageRequest = new PageRequest(page,size);
        Page<OrderDto> result = orderService.findList(openid,pageRequest);
        return ResultDtoUtil.success(result.getContent());
    }

    //订单详情
    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public ResultDto<OrderDto> detail(@RequestParam("openid") String openid,
                                      @RequestParam("orderId") String orderId){
        OrderDto orderDto = buyerService.findOrderOne(openid,orderId);
        return ResultDtoUtil.success(orderDto);
    }

    //取消订单
    @RequestMapping(value = "/cancel",method = RequestMethod.POST)
    public ResultDto<OrderDto> cancel(@RequestParam("openid") String openid,
                                      @RequestParam("orderId") String orderId){
        buyerService.cancelOrder(openid,orderId);
        return ResultDtoUtil.success();
    }
}

