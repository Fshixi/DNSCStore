package com.example.store_item.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
@Data
public class Favorites implements Serializable {
    /**
     * 收藏数据id
     *
     * @mbg.generated
     */
    private Integer fid;

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
     * 商品名
     *
     * @mbg.generated
     */
    private String title;

    /**
     * 图片地址
     *
     * @mbg.generated
     */
    private String image;

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
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime createdTime;

    public Favorites(Integer uid, Integer pid, Long price, String title, String image, String createdUser) {
        this.uid = uid;
        this.pid = pid;
        this.price = price;
        this.title = title;
        this.image = image;
        this.createdUser = createdUser;
    }
}