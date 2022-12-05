package com.example.store_item.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.store_item.entity.Order;
import com.example.store_item.entity.OrderItem;

import java.util.List;

public interface OrderService extends IService<Order> {
    //创建订单
    void createOrder(Integer aid, Integer[] cids,Integer uid);
    
    List<OrderItem> Order(Integer uid);
}
