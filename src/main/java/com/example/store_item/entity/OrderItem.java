package com.example.store_item.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
@Data
public class OrderItem implements Serializable {
    /**
     * 订单中的商品记录的id
     *
     * @mbg.generated
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 所归属的订单的id
     *
     * @mbg.generated
     */
    private Integer oid;

    /**
     * 商品的id
     *
     * @mbg.generated
     */
    private Integer pid;

    /**
     * 商品标题
     *
     * @mbg.generated
     */
    private String title;

    /**
     * 商品图片
     *
     * @mbg.generated
     */
    private String image;

    /**
     * 商品价格
     *
     * @mbg.generated
     */
    private Long price;

    /**
     * 购买数量
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