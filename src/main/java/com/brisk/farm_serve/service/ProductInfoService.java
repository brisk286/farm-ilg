package com.brisk.farm_serve.service;

import com.brisk.farm_serve.pojo.po.Product;

public interface ProductInfoService {

    Product getProductById(Long product_id);

    void insertProduct(Product product);

    void deleteProduct(Long product_id);
}
