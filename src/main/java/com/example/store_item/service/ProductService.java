package com.example.store_item.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.store_item.entity.Product;

import java.util.List;

public interface ProductService extends IService<Product> {
    
    public List<Product> getHostStore();

    public List<Product> getNewStore();

    public Product selectGood(Long id);
}
