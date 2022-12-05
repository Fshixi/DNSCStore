package com.example.store_item.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.store_item.entity.Favorites;

import java.util.List;

public interface FavoriteService extends IService<Favorites> {
    
    void insertFavorite(Integer id,Integer uid,String username);
    
    List<Favorites> selectAll(Integer uid);
    
    
}
