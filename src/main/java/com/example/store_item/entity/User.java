package com.example.store_item.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
@Data
public class User implements Serializable {
    /**
     * 用户id
     *
     * @mbg.generated
     */
    private Integer uid;

    /**
     * 用户名
     *
     * @mbg.generated
     */
    private String username;

    /**
     * 密码
     *
     * @mbg.generated
     */
    private String password;

    /**
     * 盐值
     *
     * @mbg.generated
     */
    private String salt;

    /**
     * 电话号码
     *
     * @mbg.generated
     */
    private String phone;

    /**
     * 电子邮箱
     *
     * @mbg.generated
     */
    private String email;

    /**
     * 性别:0-女，1-男
     *
     * @mbg.generated
     */
    private Integer gender;

    /**
     * 头像
     *
     * @mbg.generated
     */
    private String avatar;

    /**
     * 是否删除：0-未删除，1-已删除
     *
     * @mbg.generated
     */
    private Integer isDelete;

    /**
     * 日志-创建人
     *
     * @mbg.generated
     */
    @TableField(fill = FieldFill.INSERT)
    private String createdUser;

    /**
     * 日志-创建时间
     *
     * @mbg.generated
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdTime;

    /**
     * 日志-最后修改执行人
     *
     * @mbg.generated
     */
    @TableField(fill = FieldFill.UPDATE)
    private String modifiedUser;

    /**
     * 日志-最后修改时间
     *
     * @mbg.generated
     */
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime modifiedTime;

}