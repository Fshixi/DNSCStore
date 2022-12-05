package com.example.store_item.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.store_item.entity.*;
import com.example.store_item.mapper.OrderItemMapper;
import com.example.store_item.mapper.OrderMapper;
import com.example.store_item.service.*;
import com.example.store_item.vo.ShopCarVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class orderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    
    @Autowired
    private AddressService addressService;
    
    @Autowired
    private ShopCarService shopCarService;
    
    @Autowired
    private ProductService productService;
    
    @Autowired 
    private OrderItemService orderItemService;
    
    @Autowired
    private OrderService orderService;
    
    @Override
    public void createOrder(Integer aid, Integer[] cids,Integer uid) {
        LambdaQueryWrapper<Address> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Address::getAid,aid).eq(Address::getUid,uid);
        Address address = addressService.getOne(wrapper);
        Order order=new Order();
        
        List<OrderItem> orderItemList=new ArrayList<>();
        log.info(address.toString());
        Long temp= Long.valueOf(0);
        
        if (cids!=null){
            for (int i = 0; i < cids.length; i++) {
                OrderItem orderItem=new OrderItem();
                LambdaQueryWrapper<Cart> queryWrapper=new LambdaQueryWrapper<>();
                queryWrapper.eq(Cart::getCid,cids[i]);
                Cart cart = shopCarService.getOne(queryWrapper);
                Product product = productService.getById(cart.getPid());
                temp=temp+cart.getNum()*product.getPrice();
                orderItem.setPid(cart.getPid());
                orderItem.setTitle(product.getTitle());
                orderItem.setImage(product.getImage());
                orderItem.setPrice(product.getPrice());
                orderItem.setNum(cart.getNum());
//                orderItemService.save(orderItem);
                orderItemList.add(i,orderItem);
                log.info(cart.toString());
                log.info(orderItem.toString());
            }
            order.setUid(uid);
            order.setRecvName(address.getName());
            order.setRecvPhone(address.getPhone());
            order.setRecvProvince(address.getProvinceName());
            order.setRecvCity(address.getCityName());
            order.setRecvArea(address.getAreaName());
            order.setRecvAddress(address.getAddress());
            order.setTotalPrice(temp);
            order.setStatus(1);
            log.info(order.toString());
            orderService.save(order);
            LambdaQueryWrapper<Order> queryWrapper=new LambdaQueryWrapper();
            queryWrapper.eq(Order::getUid,uid).orderByDesc(Order::getCreatedTime);
            List<Order> list = orderService.list(queryWrapper);
            Order order1 = list.get(0);
            log.info(order1.toString());
            Integer oid = order1.getOid();
            for (int i = 0; i < orderItemList.size(); i++) {
                orderItemList.get(i).setOid(oid);
                log.info(orderItemList.get(i).toString());
                orderItemService.save(orderItemList.get(i));
                LambdaQueryWrapper<Cart> wrapper1=new LambdaQueryWrapper();
                wrapper1.eq(Cart::getPid,orderItemList.get(i).getPid()).eq(Cart::getUid,uid);
                shopCarService.remove(wrapper1);
            }
            


        }


    }

    @Override
    public List<OrderItem> Order(Integer uid) {
        List<OrderItem> list=new ArrayList<>();
        LambdaQueryWrapper<Order> wrapper=new LambdaQueryWrapper();
        wrapper.eq(Order::getUid,uid);
        List<Order> orderList = orderService.list(wrapper);
        for (Order order : orderList) {
            Integer oid = order.getOid();
            LambdaQueryWrapper<OrderItem> queryWrapper=new LambdaQueryWrapper();
            queryWrapper.eq(OrderItem::getOid,oid);
            List<OrderItem> orderItemList = orderItemService.list(queryWrapper);
            for (OrderItem orderItem : orderItemList) {
                list.add(orderItem);
            }
        }
        return list;
    }
}
