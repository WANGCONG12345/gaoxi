package com.gaoxi.gaoxicommonservicefacade.entity.user;


import com.gaoxi.gaoxicommonservicefacade.enumerate.user.UserStateEnum;
import com.gaoxi.gaoxicommonservicefacade.enumerate.user.UserTypeEnum;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserEntity implements Serializable {
    /**主键*/
    private String id;
    /**用户名*/
    private String username;
    /**密码*/
    private String password;
    /**手机号*/
    private String phone;
    /**邮箱*/
    private String email;
    /**营业执照照片*/
    private String licencePic;
    /**注册时间*/
    private Timestamp regiesterTime;
    /**用户类型*/
    private UserTypeEnum userTypeEnum;
    /**账号状态*/
    private UserStateEnum userStateEnum;
    /**用户的角色*/
    private RoleEntiry roleEntiry;

    public java.lang.String getUsername() {
        return username;
    }

    public void setUsername(java.lang.String username) {
        this.username = username;
    }

    public java.lang.String getPassword() {
        return password;
    }

    public void setPassword(java.lang.String password) {
        this.password = password;
    }

    public java.lang.String getPhone() {
        return phone;
    }

    public void setPhone(java.lang.String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public java.lang.String getLicencePic() {
        return licencePic;
    }

    public void setLicencePic(java.lang.String licencePic) {
        this.licencePic = licencePic;
    }

    public Timestamp getRegiesterTime() {
        return regiesterTime;
    }

    public void setRegiesterTime(Timestamp regiesterTime) {
        this.regiesterTime = regiesterTime;
    }

    public UserTypeEnum getUserTypeEnum() {
        return userTypeEnum;
    }

    public void setUserTypeEnum(UserTypeEnum userTypeEnum) {
        this.userTypeEnum = userTypeEnum;
    }

    public UserStateEnum getUserStateEnum() {
        return userStateEnum;
    }

    public void setUserStateEnum(UserStateEnum userStateEnum) {
        this.userStateEnum = userStateEnum;
    }

    public RoleEntiry getRoleEntiry() {
        return roleEntiry;
    }

    public void setRoleEntiry(RoleEntiry roleEntiry) {
        this.roleEntiry = roleEntiry;
    }

    public java.lang.String getId() {

        return id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", licencePic='" + licencePic + '\'' +
                ", regiesterTime=" + regiesterTime +
                ", userTypeEnum=" + userTypeEnum +
                ", userStateEnum=" + userStateEnum +
                ", roleEntiry=" + roleEntiry +
                '}';
    }
}
