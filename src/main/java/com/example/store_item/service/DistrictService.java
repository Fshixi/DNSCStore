package com.example.store_item.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.store_item.entity.DictDistrict;

import java.util.List;

public interface DistrictService extends IService<DictDistrict> {
    List<DictDistrict> district();

    List<DictDistrict> getParent(String parent);
}
