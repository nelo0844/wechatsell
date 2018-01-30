package com.dan.sell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weixin")
public class WeixinController {

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public void auth(@RequestParam("code") String code){
        System.out.println("code = " + code);
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxd889b96d5e406376&secret=605f8813fb7c8216be096bf344c42959&code="+ code +"&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        System.out.println("response = " + response);
    }


}
