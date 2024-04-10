package com.yuda.houserent.constant;

public class Constant {
    //用户session的key
    public static final String SESSION_USER_KEY="user";
    //上传路径
    public static final String UPLOADS_ABSOLUTE_PATH="/uploads/";
    //上传目录
    public static final String UPLOADS_PATH=System.getProperties().getProperty("user.home")+UPLOADS_ABSOLUTE_PATH;
    //图片session前缀
    public static final String SESSION_IMG_PREFIX="SESSION_IMG_";
    //最小租住天数
    public static final Integer MIN_RENT_DAYS=7;
    //首页显示房子数量
    public static final Integer INDEX_HOUSE_NUM=6;
}
