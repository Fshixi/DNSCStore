package com.example.store_item.controller;

import com.alibaba.fastjson.JSON;
import com.example.store_item.common.JsonResult;
import com.example.store_item.entity.DictDistrict;
import com.example.store_item.service.DistrictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/district")
@Slf4j
public class districtController {
    @Autowired
    private DistrictService districtService;
    //新增地址，获取城市信息
    @PostMapping
    public JsonResult district(){
        List<DictDistrict> district = districtService.district();
        return new JsonResult(200,district);
    }
    //获取市的信息
    @GetMapping()
    public JsonResult getParent(String parent){
        List<DictDistrict> parentList = districtService.getParent(parent);
        return new JsonResult(200,parentList);
    }
    
    
    
}
