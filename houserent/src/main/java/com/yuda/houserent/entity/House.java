package com.yuda.houserent.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yuda.houserent.BaseController.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/*
房子信息
 */
@Data
@TableName("t_house")
public class House extends BaseEntity {
    /**
     * 东房用户id
     */

    private Long userId;
    /**
     * 出租类型：整租whole，合租share
     */

    private String rentType;
    /**
     * 房屋名称
     */

    private String title;
    /**
     * 述详细描内容
     */

    private String content;
    /**
     * 市城
     */

    private String city;
    /**
     * 细地址详
     */

    private String address;
    /**
     * 略图缩
     */
    private String thumbnailUrl;
    /**
     * 番图轮
     */

    private String slideUrl;
    /**
     * 租金额月
     */

    private Integer monthRent;
    /**
     * 态状：0未出组，1已出租，-1已下架，-2待审核，-3审核不通过
     */

    private Integer status;
    /**
     * 产房证号
     */

    private String cetificateNo;
    /**
     * 生间卫数量
     */

    private Integer toiletNum;
    /**
     * 间数量房
     */
    private Integer kichenNum;
    /**
     * 厅客数量
     */
    private Integer livingRoomNum;
    /**
     * 室卧数量
     */
    private Integer bedroomNum;
    /**
     * 否有空调是1是0否
     */
    private Integer hasAirConditioner;
    /**
     * 积面
     */
    private BigDecimal area;
    /**
     * 前所在当楼层数
     */
    private Integer floor;
    /**
     * 子房最大楼层数
     */
    private Integer maxFloor;
    /**
     * 否有电梯是1有0无
     */
    private Integer hasElevator;
    /**
     * 成建年份
     */
    private Integer buildYear;
    /**
     * 响影
     */
    private String direction;
    /**
     * 上次开始入住时间
     */
    private Date lastOrdeerStartTime;
    /**
     * 次结束上入住时间
     */
    private Date lastOrderEndTime;
    /**
     * 纬度经
     */
    private String longitudeLatitude;
    /**
     * 系人姓名联
     */
    private String contactName;
    /**
     * 联系人手机
     */
    private String contactPhone;
    //轮播图列表
    @TableField(exist = false)
    private List<String> slideImgList;
    //合租列表
    @TableField(exist = false)
    private List<House> shareHouseList;
    //该房子的订单
    @TableField(exist = false)
    private Order currentOrder;
}
