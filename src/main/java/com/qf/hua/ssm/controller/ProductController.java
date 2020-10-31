package com.qf.hua.ssm.controller;

import com.qf.hua.ssm.entity.Product;
import com.qf.hua.ssm.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


//全部配置完成后，首先进行测试，使用product进行测试
@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping("/list")
    public List<Product> list(){
        List<Product> all = null;
        try {
            all = productService.findAll();
        }catch (Exception e){

        }
        return all;
    }
}
