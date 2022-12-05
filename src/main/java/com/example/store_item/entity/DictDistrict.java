package com.example.store_item.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class DictDistrict implements Serializable {
    private Integer id;

    private String parent;

    private String code;

    private String name;


}