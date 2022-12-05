package com.example.store_item.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
@Data
public class ProductCategory implements Serializable {
    /**
     * 主键
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 父分类id
     *
     * @mbg.generated
     */
    private Long parentId;

    /**
     * 名称
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 状态   1：正常   0：删除
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     * 排序号
     *
     * @mbg.generated
     */
    private Integer sortOrder;

    /**
     * 是否是父分类   1：是  0：否
     *
     * @mbg.generated
     */
    private Integer isParent;

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