package com.brisk.farm_serve.mbg.mapper;

import com.brisk.farm_serve.pojo.po.Product;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {

    Product getProductById(@Param("product_id") Long product_id);

    void insertProduct(@Param("product") Product product);

    void deleteProduct(@Param("product_id") Long product_id);

}
