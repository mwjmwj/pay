package com.pay.controller;

import com.pay.paychannel.PayChannel;
import com.pay.paychannel.wapper.PayWapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * create by wenjie.mao
 * Date: 2019/9/19
 */

@Controller
@RequestMapping("/gatway/pay")
public class PayController {

    private PayWapper payWapper;

    private Object lock = new Object();

    /**
     * redirect 支付
     */
    private final String REDIRECT_PAY_CHANNEL = "1";
    /**
     * 页面提交支付
     */
    private final String PAGE_PAY_CHANNEL = "0";

    @Autowired
    private PayChannel payChannel;


    @RequestMapping("/rchannel")
    @ResponseBody
    public String redirectPay(HttpServletRequest request, HttpServletResponse response) throws IOException {

//        PayBaseEntity payBase = payWapper.getPayChannelBaseData("userUUID");
//        if (PAGE_PAY_CHANNEL.equals(payBase.getPayType())) {

        response.sendRedirect(request.getContextPath() + "/gatway/pay/pchannel");
//        }
//        payChannel.pay(request, response, payWapper);
        return "success";
    }

    @RequestMapping("/pchannel")
    public ModelAndView pagePay(HttpServletRequest request, HttpServletResponse response) {

        Map<String, String> pay = payChannel.pay(request, response, payWapper);

        return new ModelAndView();
    }

    @ModelAttribute
    public void init() {
//        if (null == payWapper) {
//            synchronized (lock) {
//                if (null == payWapper) {
//                    payWapper = new PayWapper(null, null, null);
//                }
//            }
//        }

    }

}
