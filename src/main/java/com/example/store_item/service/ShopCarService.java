package com.example.store_item.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.store_item.common.JsonResult;
import com.example.store_item.entity.Cart;
import com.example.store_item.vo.ShopCarVO;

import java.util.List;

public interface ShopCarService extends IService<Cart> {
    List<Cart> showShoppCar();

    Boolean addShopCar(Cart cart);
    
    Integer reduceNum(Integer cid,Integer uid,String username);
    
    Integer addNum(Integer cid,Integer uid,String username);

    List<ShopCarVO> getVOBydCid(Integer[] cids,Integer uid);
    
    void deleteByCid(Integer cid,Integer uid);

    void deleteGoods(Integer[] cids,Integer uid);


}
