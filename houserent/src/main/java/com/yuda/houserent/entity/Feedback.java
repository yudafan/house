package com.yuda.houserent.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yuda.houserent.BaseController.BaseEntity;
import lombok.Data;

/**
 * 用户反馈
 */
@Data
@TableName("t_feedback")
public class Feedback extends BaseEntity {
    /**
     * 馈标题反
     */
    private String title;
    /**
     * 馈内容反
     */
    private String content;
    /**
     * 户用id
     */
    private Long userId;
    /**
     * 理状态处：0待处理1已处理
     */
    private Integer status;
    /**
     * 复内容回
     */
    private String reply;
    /**
     * 系人联姓名
     */
    private String contactName;
    /**
     * 系人邮箱联
     */
    private String contactEmail;

}
