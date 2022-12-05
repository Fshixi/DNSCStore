package com.example.store_item.controller;

import com.alibaba.fastjson.JSON;
import com.example.store_item.common.JsonResult;
import com.example.store_item.entity.Cart;
import com.example.store_item.mapper.ShopCarMapper;
import com.example.store_item.service.ShopCarService;
import com.example.store_item.vo.ShopCarVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shopcar")
@Slf4j
public class shopCarController {
    @Autowired
    private ShopCarService shopCarService;
    
    @Autowired
    private ShopCarMapper shopCarMapper;
    
    
    @PostMapping("/addtoshopcar")
    public JsonResult addShopCar(Cart cart,Integer  amount,HttpSession session){
        //cart中没有price价格
        Integer uid = (Integer) session.getAttribute("uid");
        System.out.println(amount);
        cart.setUid(uid);
        cart.setNum(amount);
        log.info(cart.toString());
        shopCarService.addShopCar(cart);
        return new JsonResult(200);
    }
    @GetMapping({"","/"})
    public JsonResult shopList(HttpSession session){
        Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
        List<ShopCarVO> list=shopCarMapper.findVOByUid(uid);
        return new JsonResult(200,list);
    }
    
    @PostMapping("{cid}/reducenum")
    public JsonResult reduceNum(@PathVariable Integer cid, HttpSession session){
        Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
        String username = (String) session.getAttribute("username");
        Integer num = shopCarService.reduceNum(cid, uid, username);
        return new JsonResult(200,num);


    }

    @PostMapping("{cid}/addnum")
    public JsonResult addNum(@PathVariable Integer cid,HttpSession session){
        Integer url = Integer.valueOf(session.getAttribute("uid").toString());
        String username = (String) session.getAttribute("username");
        Integer num = shopCarService.addNum(cid, url, username);
        return new JsonResult(200,num);
        
    }

    @GetMapping("/list")
    public JsonResult getVOBydCid(Integer[] cids,HttpSession session){
        if (cids==null){
            return new JsonResult(100,null);
        }
        Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
        List<ShopCarVO> voBydCid = shopCarService.getVOBydCid(cids, uid);

        return new JsonResult(200,voBydCid);
    }
    
    @PostMapping("{cid}/delete")
    public JsonResult deleteByCid(@PathVariable Integer cid,HttpSession session){
        Integer uid = (Integer) session.getAttribute("uid");
        shopCarService.deleteByCid(cid,uid);
        return new JsonResult(200);
    }
    
    @GetMapping("/deletegoods")
    public JsonResult deleteGoods(Integer[] cids,HttpSession session){
        Integer uid = (Integer) session.getAttribute("uid");
        shopCarService.deleteGoods(cids,uid);
        return new JsonResult(200);
    }
    
}
