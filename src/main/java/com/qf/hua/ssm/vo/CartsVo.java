package com.qf.hua.ssm.vo;

import lombok.Data;

/*
* 安全考虑，不暴露表结构
* 对数据进行处理
* vo对象一般作为Service层返回值
* */
@Data
public class CartsVo {
    private Integer cartsId;

    private Integer num;

    private Integer productId;

    private Integer userId;

}
