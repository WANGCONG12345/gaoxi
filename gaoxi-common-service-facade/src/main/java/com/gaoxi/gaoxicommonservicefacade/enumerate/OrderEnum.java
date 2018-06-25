package com.gaoxi.gaoxicommonservicefacade.enumerate;

/**
 * @author acong
 * @date 2018年6月15日13:30:18
 * @description 排序规则枚举
 */
public enum OrderEnum {
    DESC(1,"DESC"),
    ASC(2,"ASC");
    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    OrderEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public static String getMsgByCode(int code){
        for (OrderEnum orderEnum:OrderEnum.values()) {
            if (orderEnum.code == code){
                return  orderEnum.msg;
            }
        }
        return null;
    }

}
