package com.example.store_item.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.store_item.common.JsonResult;
import com.example.store_item.entity.Product;
import com.example.store_item.mapper.ProductMapper;
import com.example.store_item.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.spec.PSource;
import java.util.List;

@Service
public class productServiceImpl extends ServiceImpl<ProductMapper,Product > implements ProductService {
    @Autowired
    private ProductService productService;
    
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getHostStore() {
        List<Product> list = productMapper.getHostStore();;
        return list;
    }

    @Override
    public List<Product> getNewStore() {
        List<Product> newStore = productMapper.getNewStore();

        return newStore;
    }

    @Override
    public Product selectGood(Long id) {
        Product product = productMapper.selectById(id);
        return product;
    }
}
