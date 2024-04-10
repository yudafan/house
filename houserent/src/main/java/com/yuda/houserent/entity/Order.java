package com.yuda.houserent.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yuda.houserent.BaseController.BaseEntity;
import lombok.Data;

import java.util.Date;
/**
 * 订单表
 * @TableName t_order
 */
@Data
@TableName("t_order")
public class Order extends BaseEntity {
        /**
         * 客用户租id
         */
        private Long customerUserId;
        /**
         * 东用户房id
         */
        private Long ownerUserId;
        /**
         * 子房id
         */
        private Long houseId;
        /**
         * 单订状态：-3租客已取消，-2待签合同，-1待付款0生效中，1已到期，2退租申请，3退租申请不通过
         */
        private Integer status;
        /**
         * 租金月
         */
        private Integer monthRent;
        /**
         * 住天数租
         */
        private Integer dayNum;
        /**
         * 金额总
         */
        private Integer totalAmount;
        /**
         * 始日期开
         */
        private Date startDate;
        /**
         * 束日期结
         */
        private Date endDate;
        //房子信息
    @TableField(exist = false)
    private House house;
    //租客用户信息
    @TableField(exist = false)
    private User customerUser;
    //房东用户信息
    @TableField(exist = false)
    private User ownerUser;

}
