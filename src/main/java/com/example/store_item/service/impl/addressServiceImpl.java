package com.example.store_item.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.store_item.entity.Address;
import com.example.store_item.entity.DictDistrict;
import com.example.store_item.mapper.AddressMapper;
import com.example.store_item.service.AddressService;
import com.example.store_item.service.DistrictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class addressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {
    @Autowired
    private AddressService addressService;
    
    @Autowired
    private DistrictService districtService;
    
    @Override
    public void addNewAddress(Address address) {
        LambdaQueryWrapper<DictDistrict> queryWrapper=new LambdaQueryWrapper();
        queryWrapper.eq(DictDistrict::getParent,86).eq(DictDistrict::getCode,address.getProvinceCode());
        DictDistrict province = districtService.getOne(queryWrapper);
        log.info(province.toString());
        address.setProvinceName(province.getName());
        LambdaQueryWrapper<DictDistrict> lambdaQueryWrapper=new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(DictDistrict::getParent,address.getProvinceCode()).eq(DictDistrict::getCode,address.getCityCode());
        DictDistrict city=districtService.getOne(lambdaQueryWrapper);
        log.info(city.toString());
        address.setCityName(city.getName());
        LambdaQueryWrapper<DictDistrict> wrapper=new LambdaQueryWrapper();
        wrapper.eq(DictDistrict::getParent,address.getCityCode()).eq(DictDistrict::getCode,address.getAreaCode());
        DictDistrict area=districtService.getOne(wrapper);
        log.info(area.toString());
        address.setAreaName(area.getName());
        addressService.save(address);

    }

    @Override
    public List<Address> addressList(Integer uid) {
        LambdaQueryWrapper<Address> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Address::getUid,uid);
        List<Address> list = addressService.list(wrapper);
        return list;
    }

    @Override
    public void deleteByAid(Integer aid, Integer uid) {
        LambdaQueryWrapper<Address> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Address::getUid,uid).eq(Address::getAid,aid);
        addressService.remove(wrapper);
    }
}
