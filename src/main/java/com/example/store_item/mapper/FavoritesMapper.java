package com.example.store_item.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.store_item.entity.Favorites;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FavoritesMapper extends BaseMapper<Favorites> {
}
