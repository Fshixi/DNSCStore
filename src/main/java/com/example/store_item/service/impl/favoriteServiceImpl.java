package com.example.store_item.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.store_item.entity.Favorites;
import com.example.store_item.entity.Product;
import com.example.store_item.mapper.FavoritesMapper;
import com.example.store_item.service.ProductService;
import com.example.store_item.service.FavoriteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class favoriteServiceImpl extends ServiceImpl<FavoritesMapper, Favorites> implements FavoriteService {
    @Autowired
    private ProductService productService;
    
    @Autowired
    private FavoriteService favoriteService;
    
    
    @Override
    public void insertFavorite(Integer id,Integer uid,String username) {
        Product product = productService.getById(id);
        LambdaQueryWrapper<Favorites> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Favorites::getPid,product.getId()).eq(Favorites::getUid,uid);
        Favorites temp = favoriteService.getOne(queryWrapper);
        if (temp==null){
            Favorites favorites=new Favorites(uid,id,product.getPrice(),product.getTitle(),product.getImage(),username);
            favoriteService.save(favorites);
            return;
        }
//        temp.setCreatedTime(LocalDateTime.now());
        favoriteService.update(temp,queryWrapper);
        
    }

    @Override
    public List<Favorites> selectAll(Integer uid) {
        LambdaQueryWrapper<Favorites> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Favorites::getUid,uid);
        wrapper.orderByDesc(Favorites::getCreatedTime);
        List<Favorites> favorites = favoriteService.list(wrapper);
        return favorites;

    }
}
