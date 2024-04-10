package com.yuda.houserent.enums;
/*
用户角色枚举
 */
public enum HouseRentTypeEnum {
    //整租
    WHOLE("whole"),
    //合租
    SHARE("share"),


    ;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String value;
    HouseRentTypeEnum(String value){
        this.value=value;
    }


}
