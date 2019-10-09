package com.pay.paychannel;

import com.pay.dao.PayDao;
import com.pay.paychannel.wapper.PayWapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * create by wenjie.mao
 * Date: 2019/9/19
 */
@Component
public class PayChannel implements IPayChannel {

    @Autowired
    private PayDao payDao;

    @Override
    public Map<String, String> pay(HttpServletRequest request, HttpServletResponse response, PayWapper payWapper) {
        return null;
    }

    @Override
    public Map<String, String> payCallBack(HttpServletRequest request, HttpServletResponse response) {

        return null;
    }

    @Override
    public Map<String, String> df(Map<String, String> payParam) {

        return null;
    }

    @Override
    public Map<String, String> dfCallBack(HttpServletRequest request, HttpServletResponse response) {

        return null;
    }
}
