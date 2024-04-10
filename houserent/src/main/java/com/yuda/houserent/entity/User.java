package com.yuda.houserent.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yuda.houserent.BaseController.BaseEntity;
import lombok.Data;

/*
用户信息
 */
@Data
@TableName("t_user")
public class User extends BaseEntity {

    /**
     * 用户名/号账
     */
    private String userName;
    /**
     * 名姓
     */
    private String userDisplayName;
    /**
     * 机号手
     */
    private String phone;
    /**
     * 箱邮
     */
    private String email;
    /**
     * 密码
     */
    private String userPass;
    /**
     * 身份证
     */
    private String idCard;
    /**
     * 头像
     */
    private String userAvatar;
    /**
     * 人个描述
     */
    private String userDesc;
    /**
     * 1正常0禁用
     */
    private Integer status;
    /**
     * 色角，管理员admin，房东owner，租客customer
     */
    private String role;
    /**
     * 别性
     */
    private String sex;
    /**
     * 余爱好业
     */
    private String hobby;
    /**
     * 职业
     */
    private String job;


}
