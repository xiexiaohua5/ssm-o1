package com.qf.hua.ssm.entity;

import lombok.Data;

/**
    * 购物车
    */
@Data
public class Carts {
    private Integer cartsId;

    /**
    * 商品的数量
    */
    private Integer num;

    /**
    * 商品的外键
    */
    private Integer productId;

    /**
    * 用户id
    */
    private Integer userId;

    /**
    * 0 表示正常 1 表示删除
    */
    private Integer status;


}