package com.qf.hua.ssm.mapper;

import com.qf.hua.ssm.entity.Carts;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartsMapper {

    int insert(Carts carts);

    Carts selectByUserIdAndProductId(@Param("userId") int userId, @Param("productId") int productId);

    int updateNumByCartId(@Param("cartId") int cart, @Param("num") int num);

    List<Carts> selectList(int userId);
}