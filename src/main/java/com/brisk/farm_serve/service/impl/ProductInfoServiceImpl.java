package com.brisk.farm_serve.service.impl;

import com.brisk.farm_serve.entity.Product;
import com.brisk.farm_serve.mbg.mapper.ProductMapper;
import com.brisk.farm_serve.service.ProductInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Resource
    ProductMapper productMapper;

    @Override
    public Product getProductById(Long product_id) {
        return productMapper.getProductById(product_id);
    }

    @Override
    public void insertProduct(Product product) {
        productMapper.insertProduct(product);
    }

    @Override
    public void deleteProduct(Long product_id) {
        productMapper.deleteProduct(product_id);
    }
}
