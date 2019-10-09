package com.pay.entity;

/**
 * create by wenjie.mao
 * Date: 2019/9/19
 */
public class PayBaseEntity {

    private String payId;

    private String payType;

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }
}
