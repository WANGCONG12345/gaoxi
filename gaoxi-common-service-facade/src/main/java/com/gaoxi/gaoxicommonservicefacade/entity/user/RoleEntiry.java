package com.gaoxi.gaoxicommonservicefacade.entity.user;

import com.gaoxi.gaoxicommonservicefacade.entity.user.MenuEntity;
import com.gaoxi.gaoxicommonservicefacade.entity.user.PermissionEntity;

import java.io.Serializable;
import java.util.List;

public class RoleEntiry implements Serializable{
    /**主键*/
    private String id;
    /**角色名称*/
    private String name;
    /**角色描述*/
    private String desc;
    /**角色能访问的菜单*/
    private List<MenuEntity> munuList;
    /**角色拥有的权限*/
    private  List<PermissionEntity> permissionList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<MenuEntity> getMunuList() {
        return munuList;
    }

    public void setMunuList(List<MenuEntity> munuList) {
        this.munuList = munuList;
    }

    public List<PermissionEntity> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<PermissionEntity> permissionList) {
        this.permissionList = permissionList;
    }

    @Override
    public String toString() {
        return "RoleEntiry{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", munuList=" + munuList +
                ", permissionList=" + permissionList +
                '}';
    }
}
