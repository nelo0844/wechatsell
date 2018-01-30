package com.dan.sell.controller;

import com.dan.sell.enums.ResultEnum;
import com.dan.sell.exception.SellException;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;

@Controller
@RequestMapping("/wechat")
public class WechatController {

    private final Logger logger = LoggerFactory.getLogger(WechatController.class);

    @Autowired
    private WxMpService wxMpService;

    private final String OAUTH2_SCOPE_USER_INFO = "snsapi_userinfo";

    @RequestMapping(value = "/authorize",method = RequestMethod.GET)
    public String authorize(@RequestParam("returnUrl") String returnUrl){
        //1.配置

        //2.调用方法
        String url = "http://tdgy.natapp4.cc/sell/wechat/userInfo";
        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, OAUTH2_SCOPE_USER_INFO, URLEncoder.encode(returnUrl));
        logger.info("【微信网页授权】获取code，redirectUrl = {}" + redirectUrl);
        return "redirect:" + redirectUrl;
    }

    @RequestMapping(value = "/userInfo",method = RequestMethod.GET)
    public String userInfo(@RequestParam("code") String code,
                         @RequestParam("state") String returnUrl){
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e){
            logger.error("【微信网页授权】{}", e);
            throw new SellException(ResultEnum.WX_MP_ERROR, e.getError().getErrorMsg());
        }
        String openId = wxMpOAuth2AccessToken.getOpenId();

        return "redirect:" + returnUrl + "?openid=" + openId;
    }
}

