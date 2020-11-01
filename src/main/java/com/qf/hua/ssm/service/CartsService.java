package com.qf.hua.ssm.service;


import com.qf.hua.ssm.request.CartsRequestParams;
import com.qf.hua.ssm.vo.CartsVo;

import java.util.List;


public interface CartsService {
    int saveCarts(CartsRequestParams cartsRequestParams);

    List<CartsVo> findAllCarts(int userId);

    int removeCarts(int userId, List<Integer> productIds);

    int updateNum(CartsRequestParams cartsRequestParams);

}
