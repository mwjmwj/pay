package com.pay.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * create by wenjie.mao
 * Date: 2019/10/9
 */
@TableName("zc_log")
@Data
public class ZcLog {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("request_method_name")
    private String requestMethodName;

    @TableField("request_args")
    private String requestArgs;

    @TableField("request_response")
    private String requestResponse;

    @TableField("ip")
    private String ip;

    @TableField("request_time")
    private Long requestTime;

    @TableField("create_time")
    private Date createTime;

}
