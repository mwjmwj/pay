package com.pay.paychannel.wapper;

import com.pay.entity.PayBaseEntity;
import com.pay.entity.PayConfigEntity;
import com.pay.entity.PayDFEntity;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * create by wenjie.mao
 * Date: 2019/9/19
 */
public class PayWapper {

    public Map<String,PayBaseEntity> payBaseData;

    public Map<String,PayConfigEntity> payConfigData;

    public Map<String,PayDFEntity> dfConfigData;

    public PayWapper(List<PayBaseEntity> payBaseData,List<PayConfigEntity> payConfigData,
                     List<PayDFEntity> dfConfigData){
        this.dfConfigData = dfConfigData.stream().collect(Collectors.toMap(PayDFEntity::getPayId,o->o,(o,n)->o));
        this.payBaseData = payBaseData.stream().collect(Collectors.toMap(PayBaseEntity::getPayId,o->o,(o,n)->o));;
        this.payConfigData = payConfigData.stream().collect(Collectors.toMap(PayConfigEntity::getPayId,o->o,(o,n)->o));;
    }

    public  PayBaseEntity getPayChannelBaseData(String userUUID){
        return payBaseData.get(userUUID);
    }

    public  PayConfigEntity getPayChannelConfigData(String userUUID){
        return payConfigData.get(userUUID);
    }

    public  PayDFEntity getPayChannelDfData(String userUUID){
        return dfConfigData.get(userUUID);
    }

}
