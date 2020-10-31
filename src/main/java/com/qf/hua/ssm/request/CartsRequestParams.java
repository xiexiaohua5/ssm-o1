package com.qf.hua.ssm.request;

import lombok.Data;

/*
*购物车参数实体类
* */
@Data
public class CartsRequestParams {
    private Integer userId;
    private Integer num;
    private Integer productId;

}
