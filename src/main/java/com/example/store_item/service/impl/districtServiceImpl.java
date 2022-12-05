package com.example.store_item.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.store_item.entity.DictDistrict;
import com.example.store_item.mapper.DistrictMapper;
import com.example.store_item.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class districtServiceImpl extends ServiceImpl<DistrictMapper, DictDistrict> implements DistrictService {
    @Autowired
    private DistrictService districtService;
    @Override
    public List<DictDistrict> district() {
        LambdaQueryWrapper<DictDistrict> wrapper=new LambdaQueryWrapper();
        wrapper.eq(DictDistrict::getParent,86);
        List<DictDistrict> list = districtService.list(wrapper);
        return list;
    }

    @Override
    public List<DictDistrict> getParent(String parent) {
        LambdaQueryWrapper<DictDistrict> wrapper=new LambdaQueryWrapper();
        wrapper.eq(DictDistrict::getParent,parent);
        List<DictDistrict> list = districtService.list(wrapper);
        return list;
    }
}
