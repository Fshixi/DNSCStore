package com.example.store_item.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.store_item.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderItemMapper extends BaseMapper<OrderItem> {
}
