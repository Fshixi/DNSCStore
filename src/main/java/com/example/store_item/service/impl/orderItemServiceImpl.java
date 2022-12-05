package com.example.store_item.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.store_item.entity.OrderItem;
import com.example.store_item.mapper.OrderItemMapper;
import com.example.store_item.service.OrderItemService;
import org.springframework.stereotype.Service;

@Service
public class orderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService {
}
