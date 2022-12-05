package com.example.store_item.controller;

import com.example.store_item.common.JsonResult;
import com.example.store_item.entity.Address;
import com.example.store_item.entity.DictDistrict;
import com.example.store_item.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/address")
@Slf4j
public class addressController {
    @Autowired
    private AddressService addressService;
    
    //查看地址列表
    @GetMapping
    public JsonResult address(HttpSession session){
        Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
        List<Address> addresses = addressService.addressList(uid);
        return new JsonResult(200,addresses);
    }
    //新建地址
    @PostMapping("/addnewaddress")
    public JsonResult addNewAddress(Address address, HttpSession session){
        Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
        address.setUid(uid);
        addressService.addNewAddress(address);
        log.info(address.toString());
        return new JsonResult(200);
    }
    //删除地址
    @PostMapping("/{aid}/delete")
    public JsonResult deleteAddress(@PathVariable Integer aid,HttpSession session){
        Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
        addressService.deleteByAid(aid,uid);
        return new JsonResult(200);
    }
}
