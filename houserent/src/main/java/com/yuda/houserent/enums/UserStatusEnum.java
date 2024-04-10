package com.yuda.houserent.enums;

public enum UserStatusEnum {
    //正常
    ENABLE(1),
    //禁用
    DISABLE(0),
    ;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    private Integer value;
    UserStatusEnum(Integer value){
        this.value=value;
    }


}
