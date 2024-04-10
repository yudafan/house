package com.yuda.houserent.enums;
/*
用户角色枚举
 */
public enum UserRoleEnum {
    //管理员
    ADMIN("admin"),
    //房东
    OWNER("owner"),
    //租客
    CUSTOMER("customer"),
    ;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String value;
    UserRoleEnum(String value){
        this.value=value;
    }


}
