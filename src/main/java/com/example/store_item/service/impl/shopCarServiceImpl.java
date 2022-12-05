package com.example.store_item.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.store_item.entity.Cart;
import com.example.store_item.entity.Product;
import com.example.store_item.mapper.ShopCarMapper;
import com.example.store_item.service.ProductService;
import com.example.store_item.service.ShopCarService;
import com.example.store_item.vo.ShopCarVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class shopCarServiceImpl extends ServiceImpl<ShopCarMapper, Cart> implements ShopCarService {
    @Autowired
    private ShopCarService shopCarService;
    
    @Autowired
    private ShopCarMapper shopCarMapper;
    
    @Autowired
    private ProductService productService;
    
    public List<Cart> showShoppCar(){
        List<Cart> list = shopCarService.list();
        return list;
    }

    @Override
    public Boolean addShopCar(Cart cart) {
        Integer pid = cart.getPid();
        Product product = productService.getById(pid);
        cart.setPrice(product.getPrice());
        LambdaQueryWrapper<Cart> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Cart::getUid,cart.getUid()).eq(Cart::getPid,cart.getPid());
        Cart one = shopCarService.getOne(wrapper);
        if (one==null){
            shopCarService.save(cart);
            return true;
        }
        Integer num = one.getNum();
        cart.setNum(cart.getNum()+num);
        shopCarService.update(cart,wrapper);
        return true;
    }

    @Override
    public Integer reduceNum(Integer cid, Integer uid, String username) {
        LambdaQueryWrapper<Cart> queryWrapper=new LambdaQueryWrapper();
        queryWrapper.eq(Cart::getUid,uid).eq(Cart::getCid,cid);
        Cart cart = shopCarService.getOne(queryWrapper);
        cart.setModifiedUser(username);
        if (cart.getNum()==1){
            shopCarService.remove(queryWrapper);
        }
        cart.setNum(cart.getNum()-1);
        shopCarService.update(cart,queryWrapper);
        return cart.getNum();
    }

    @Override
    public Integer addNum(Integer cid, Integer uid, String username) {
        LambdaQueryWrapper<Cart> queryWrapper=new LambdaQueryWrapper();
        queryWrapper.eq(Cart::getUid,uid).eq(Cart::getCid,cid);
        Cart cart = shopCarService.getOne(queryWrapper);
        cart.setModifiedUser(username);
        cart.setNum(cart.getNum()+1);
        shopCarService.update(cart,queryWrapper);
        return cart.getNum();
    }

    @Override
    public List<ShopCarVO> getVOBydCid(Integer[] cids,Integer uid) {
        List<ShopCarVO> voByUid = shopCarMapper.findVOByUid(uid);
        List<ShopCarVO> shopCarVOList=new ArrayList<>();
        for (ShopCarVO shopCarVO : voByUid) {
            for (Integer cid : cids) {
                if (cid==shopCarVO.getCid()){
                    shopCarVOList.add(shopCarVO);
                }
            }
        }
        return shopCarVOList;
    }

    @Override
    public void deleteByCid(Integer cid, Integer uid) {
        LambdaQueryWrapper<Cart> queryWrapper=new LambdaQueryWrapper();
        queryWrapper.eq(Cart::getCid,cid).eq(Cart::getUid,uid);
        shopCarService.remove(queryWrapper);
    }

    @Override
    public void deleteGoods(Integer[] cids, Integer uid) {
        for (Integer cid : cids) {
            LambdaQueryWrapper<Cart> wrapper=new LambdaQueryWrapper();
            wrapper.eq(Cart::getUid,uid).eq(Cart::getCid,cid);
            shopCarService.remove(wrapper);
        }
        
    }


}
