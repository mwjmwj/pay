package com.pay.paychannel;

import com.pay.paychannel.wapper.PayWapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * create by wenjie.mao
 * Date: 2019/9/19
 */
public interface IPayChannel {

    public Map<String, String> pay(HttpServletRequest request, HttpServletResponse response, PayWapper payWapper);

    public Map<String, String> payCallBack(HttpServletRequest request, HttpServletResponse response);

    public Map<String, String> df(Map<String, String> payParam);

    public Map<String, String> dfCallBack(HttpServletRequest request, HttpServletResponse response);
}
