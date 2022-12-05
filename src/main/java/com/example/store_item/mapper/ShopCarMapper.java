package com.example.store_item.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.store_item.entity.Cart;
import com.example.store_item.vo.ShopCarVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ShopCarMapper extends BaseMapper<Cart> {
    @Select("select cid,uid,pid,t_cart.price,t_cart.num,t_product.title,t_product.price AS realPrice,t_product.image " +
            "from t_cart left join t_product on t_cart.pid=t_product.id where uid=#{uid}  " +
            "order by t_cart.created_time desc")
    List<ShopCarVO> findVOByUid(Integer uid);
}
