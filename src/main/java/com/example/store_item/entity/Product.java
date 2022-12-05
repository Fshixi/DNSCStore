package com.example.store_item.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
@Data
public class Product implements Serializable {
    /**
     * 商品id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 分类id
     *
     * @mbg.generated
     */
    private Integer categoryId;

    /**
     * 商品系列
     *
     * @mbg.generated
     */
    private String itemType;

    /**
     * 商品标题
     *
     * @mbg.generated
     */
    private String title;

    /**
     * 商品卖点
     *
     * @mbg.generated
     */
    private String sellPoint;

    /**
     * 商品单价
     *
     * @mbg.generated
     */
    private Long price;

    /**
     * 库存数量
     *
     * @mbg.generated
     */
    private Integer num;

    /**
     * 图片路径
     *
     * @mbg.generated
     */
    private String image;

    /**
     * 商品状态  1：上架   2：下架   3：删除
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     * 显示优先级
     *
     * @mbg.generated
     */
    private Integer priority;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdTime;
    
    /**
     * 最后修改时间
     *
     * @mbg.generated
     */
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime modifiedTime;

    /**
     * 创建人
     *
     * @mbg.generated
     */
    private String createdUser;

    /**
     * 最后修改人
     *
     * @mbg.generated
     */
    private String modifiedUser;



}