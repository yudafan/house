package com.yuda.houserent.enums;
/*
房子状态枚举
 */
public enum HouseStatusEnum {
    /**
     * 态状：0未出组，1已出租，-1已下架，-2待审核，-3审核不通过
     */

    //未租出
    NOT_RENT(0),
    //已租出
    HAS_RENT(1),
    //已下架
    HAS_DOWN(-1),
    //待审核
    NOT_CHECK(-2),
    //审核而不通过
    CHECK_REJECT(-3)
    ;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    private Integer value;
    HouseStatusEnum(Integer value){
        this.value=value;
    }


}
