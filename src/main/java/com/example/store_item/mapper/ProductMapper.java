package com.example.store_item.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.store_item.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {
    

    @Select("select * from t_product where status = 1 order by priority desc limit 0,4")
    List<Product> getHostStore();

    @Select("select * from t_product where status = 1 order by created_time desc limit 0,4")
    List<Product> getNewStore();
    
}
