package com.example.store_item.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.store_item.entity.Address;

import java.util.List;

public interface AddressService extends IService<Address> {
    void addNewAddress(Address address);
    
    List<Address> addressList(Integer uid); 
    
    void deleteByAid(Integer aid,Integer uid);
}
