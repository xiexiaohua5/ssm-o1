package com.qf.hua.ssm.controller;


import com.qf.hua.ssm.entity.Carts;
import com.qf.hua.ssm.request.CartsRequestParams;
import com.qf.hua.ssm.service.CartsService;
import com.qf.hua.ssm.utils.ResponseEntity;
import com.qf.hua.ssm.vo.CartsVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/*
*购物车功能
* 1 添加购物车
*   如果购物车商品已经存在，直接数量相加
*   如果商品不存在，就创建该条记录
* 2 查看购物车
* 3 删除购物车
* 4 修改商品的数量
* 5 加入收藏夹的功能
* */
@RestController
@RequestMapping("/carts")
public class CartsController {

    @Resource
    private CartsService cartsService;
    /*
     * 通过用户id查询购物车信息
     * */
    @GetMapping("/list")
    public ResponseEntity<List<CartsVo>> list(@RequestParam("userId") int userId) {
        try {
            List<CartsVo> carts = cartsService.findAllCarts(userId);
            return ResponseEntity.success(carts);
        }catch (Exception e){
            return ResponseEntity.error();
        }
    }

    /*
    *添加购物车
    * */
    @PostMapping("/add")
    public ResponseEntity<Boolean> add(CartsRequestParams cartsRequestParams) {
        try {
            int i = cartsService.saveCarts(cartsRequestParams);
            if (i > 0){
                return ResponseEntity.success(true);
            }else {
                return ResponseEntity.error();
            }
        }catch (Exception e){
            return ResponseEntity.error();
        }
    }

    /**
     * 删除购物车
     * 这里用的是假删除
     * 为什么不用商品id是因为收藏夹是全部人共用的，
     * 只要别人的收藏夹还有这个东西，产品就一直还在
     * 当删除的是一堆东西的时候，就用list
     * @param cartIds
     * @return
     */
    @PutMapping("/del")
    public List<Carts> del(@RequestParam List<Integer> cartIds){
        return null;
    }

    /**
     * 修改购物车的数量
     * @param cartId
     * @return
     */
    @PutMapping("/update")
    public List<Carts> updateNum(@RequestParam("cartId") int cartId){
        return null;
    }
}




