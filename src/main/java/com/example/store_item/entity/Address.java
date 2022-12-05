package com.example.store_item.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
@Data
public class Address implements Serializable {
    /**
     * 收货地址id
     *
     * @mbg.generated
     */
    private Integer aid;

    /**
     * 归属的用户id
     *
     * @mbg.generated
     */
    private Integer uid;

    /**
     * 收货人姓名
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 省-名称
     *
     * @mbg.generated
     */
    private String provinceName;

    /**
     * 省-行政代号
     *
     * @mbg.generated
     */
    private String provinceCode;

    /**
     * 市-名称
     *
     * @mbg.generated
     */
    private String cityName;

    /**
     * 市-行政代号
     *
     * @mbg.generated
     */
    private String cityCode;

    /**
     * 区-名称
     *
     * @mbg.generated
     */
    private String areaName;

    /**
     * 区-行政代号
     *
     * @mbg.generated
     */
    private String areaCode;

    /**
     * 邮政编码
     *
     * @mbg.generated
     */
    private String zip;

    /**
     * 详细地址
     *
     * @mbg.generated
     */
    private String address;

    /**
     * 手机
     *
     * @mbg.generated
     */
    private String phone;

    /**
     * 固话
     *
     * @mbg.generated
     */
    private String tel;

    /**
     * 标签
     *
     * @mbg.generated
     */
    private String tag;

    /**
     * 是否默认：0-不默认，1-默认
     *
     * @mbg.generated
     */
    private Integer isDefault;

    /**
     * 创建人
     *
     * @mbg.generated
     */
    private String createdUser;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdTime;

    /**
     * 修改人
     *
     * @mbg.generated
     */
    private String modifiedUser;

    /**
     * 修改时间
     *
     * @mbg.generated
     */
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime modifiedTime;

    
}