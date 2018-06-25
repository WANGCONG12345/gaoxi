package com.gaoxi.gaoxicommonservicefacade.enumerate.user;


import com.gaoxi.gaoxicommonservicefacade.enumerate.BaseEnum;

public enum UserTypeEnum implements BaseEnum {
    Person(1,"个人用户"),
    Conpany(2,"企业用户"),
    ADMIN(3,"管理员");
    private int code;
    private String msg;

    UserTypeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
  public static UserTypeEnum getEnumByCode(int code){
      for (UserTypeEnum userTypeEnum:UserTypeEnum.values()) {
          if (userTypeEnum.getCode() == code){
              return userTypeEnum;
          }
      }
      return null;
  }
    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
