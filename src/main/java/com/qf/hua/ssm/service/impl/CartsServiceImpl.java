package com.qf.hua.ssm.service.impl;

import com.qf.hua.ssm.entity.Carts;
import com.qf.hua.ssm.exception.ServiceException;
import com.qf.hua.ssm.mapper.CartsMapper;
import com.qf.hua.ssm.request.CartsRequestParams;
import com.qf.hua.ssm.service.CartsService;
import com.qf.hua.ssm.utils.ColaBeanUtils;
import com.qf.hua.ssm.vo.CartsVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

import static com.qf.hua.ssm.utils.ErrorStatus.SERVICE_ERROR;

@Service
public class CartsServiceImpl implements CartsService {

    @Resource
    private CartsMapper cartsMapper;

    @Override
    public int saveCarts(CartsRequestParams cartsRequestParams) {
        int temp = 0;
        try {
            Carts carts = cartsMapper.selectByUserIdAndProductId(cartsRequestParams.getUserId(),cartsRequestParams.getProductId());
            /*
             * 判断用户的购物车中是否存在该条记录
             * */
            if (carts != null) {
                int num = carts.getNum()+cartsRequestParams.getNum();
                temp = cartsMapper.updateNumByCartId(carts.getCartsId(), num);
            }else {
                /*
                 * 涉及请求参数跟持久化对象的转化问题
                 * */
                carts = new Carts();
                /*
                 * 将对象的属性拷贝到另一个对象
                 *   属性类型名称要保持一致
                 *
                 * 参数
                 * 参数1 要拷贝的对象
                 * 参数2 目标对象
                 * 这个工具不支持list
                 * */
                BeanUtils.copyProperties(cartsRequestParams,carts);
                temp = cartsMapper.insert(carts);
            }
        }catch (Exception e){
            /*这里面的参数使用枚举来弄*/
            throw new ServiceException(SERVICE_ERROR.getMessage(),SERVICE_ERROR.getStatus());
        }
        return temp;
    }

    /*
    * 查询所有的信息
    * */
    @Override
    public List<CartsVo> findAllCarts(int uid) {
        List<CartsVo> cartsVos = null;
        try {
            List<Carts> carts = cartsMapper.selectList(uid);
            cartsVos = ColaBeanUtils.copyListProperties(carts, CartsVo::new);
        }catch (Exception e){
            throw new ServiceException(SERVICE_ERROR.getMessage(),SERVICE_ERROR.getStatus());
        }
        return cartsVos;
    }

    @Override
    public int removeCarts(int userId, List<Integer> productIds) {
        int delete = 0;
        try {
            for (Integer pis:productIds){
                delete = cartsMapper.deleteByUserIdAndProductId(userId, pis);
                if (delete > 0){
                    return delete;
                }
            }
        }catch (Exception e){
            throw new ServiceException(SERVICE_ERROR.getMessage(),SERVICE_ERROR.getStatus());
        }
        return delete;
    }

    @Override
    public int updateNum(CartsRequestParams cartsRequestParams) {
        int temp = 0;
        try {
            Carts carts = cartsMapper.selectByUserId(cartsRequestParams.getUserId());
            if (carts != null){
                int num = carts.getNum() + cartsRequestParams.getNum();
                temp = cartsMapper.updateNumByProductIdAndUserId(cartsRequestParams.getProductId(), num, cartsRequestParams.getUserId());
            }
        }catch (Exception e){
            throw new ServiceException(SERVICE_ERROR.getMessage(),SERVICE_ERROR.getStatus());
        }
        return temp;
    }
}