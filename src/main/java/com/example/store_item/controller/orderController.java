package com.example.store_item.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.store_item.common.JsonResult;
import com.example.store_item.entity.Order;
import com.example.store_item.entity.OrderItem;
import com.example.store_item.service.OrderItemService;
import com.example.store_item.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;

@RestController
@RequestMapping("/order")
@Slf4j
public class orderController {
    
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private OrderItemService orderItemService;
    
    
    
    @GetMapping("/createorder")
    public JsonResult createorder(Integer aid, Integer[] cids, HttpSession session){
        Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
        orderService.createOrder(aid,cids,uid);
        return new JsonResult(200);
    }
    
    @GetMapping
    public JsonResult Order(HttpSession session){
        Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
        List<OrderItem> list = orderService.Order(uid);
        return new JsonResult(200,list);
        
    }
    
    @GetMapping("{id}/deleteorderitem")
    public JsonResult deleteOrderItem(@PathVariable Integer id){
        LambdaQueryWrapper<OrderItem> wrapper=new LambdaQueryWrapper();
        wrapper.eq(OrderItem::getId,id);
        orderItemService.remove(wrapper);
        return new JsonResult(200);
    }
    
    
}
