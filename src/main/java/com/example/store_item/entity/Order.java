package com.example.store_item.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Order implements Serializable {
    /**
     * 订单id
     *
     * @mbg.generated
     */
    private Integer oid;

    /**
     * 用户id
     *
     * @mbg.generated
     */
    private Integer uid;

    /**
     * 收货人姓名
     *
     * @mbg.generated
     */
    private String recvName;

    /**
     * 收货人电话
     *
     * @mbg.generated
     */
    private String recvPhone;

    /**
     * 收货人所在省
     *
     * @mbg.generated
     */
    private String recvProvince;

    /**
     * 收货人所在市
     *
     * @mbg.generated
     */
    private String recvCity;

    /**
     * 收货人所在区
     *
     * @mbg.generated
     */
    private String recvArea;

    /**
     * 收货详细地址
     *
     * @mbg.generated
     */
    private String recvAddress;

    /**
     * 总价
     *
     * @mbg.generated
     */
    private Long totalPrice;

    /**
     * 状态：0-未支付，1-已支付，2-已取消，3-已关闭，4-已完成
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     * 下单时间
     *
     * @mbg.generated
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime orderTime;

    /**
     * 支付时间
     *
     * @mbg.generated
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime payTime;

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