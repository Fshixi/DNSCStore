package com.example.store_item.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
@Data
public class Cart implements Serializable {
    /**
     * 购物车数据id
     *
     * @mbg.generated
     */
    private Integer cid;

    /**
     * 用户id
     *
     * @mbg.generated
     */
    private Integer uid;

    /**
     * 商品id
     *
     * @mbg.generated
     */
    private Integer pid;

    /**
     * 加入时商品单价
     *
     * @mbg.generated
     */
    private Long price;

    /**
     * 商品数量
     *
     * @mbg.generated
     */
    private Integer num;

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