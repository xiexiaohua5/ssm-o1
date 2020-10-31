package com.qf.hua.ssm.service.impl;

import com.qf.hua.ssm.entity.Product;
import com.qf.hua.ssm.mapper.ProductMapper;
import com.qf.hua.ssm.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    ProductMapper productMapper;

    @Override
    public List<Product> findAll() {
        return productMapper.selectList();
    }
}
