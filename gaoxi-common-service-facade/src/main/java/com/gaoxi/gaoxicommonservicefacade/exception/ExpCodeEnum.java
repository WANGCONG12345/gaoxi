package com.gaoxi.gaoxicommonservicefacade.exception;

import com.gaoxi.gaoxicommonservicefacade.utils.ExpPrefixUtil;

import java.io.Serializable;
import static com.gaoxi.gaoxicommonservicefacade.utils.ExpPrefixUtil.*;

/**
 * @author acong
 * @date 2018年6月14日17:45:19
 * @description 全局的异常状态码 和 异常描述
 *
 */
public enum ExpCodeEnum implements Serializable {
    /**通用异常*/
    UNKNOW_ERROR(ComExpPrefix+"000","未知错误"),
    ERROR_404(ComExpPrefix+"001","没有该接口"),
    PARAM_NULL(ComExpPrefix+"002","参数为空"),
    NO_REPEAT(ComExpPrefix+"003","请勿重复提交"),
    SESSION_NULL(ComExpPrefix+"004","请求的sessionId不存在"),
    HTTP_REQ_METHOD_ERROE(ComExpPrefix+"005","HTTP请求方法不正确"),
    JSONERROR(ComExpPrefix+"006","JSON解析异常"),

    /**User模块异常*/
    USERNAME_NULL(UserExpPrefix+"000","用户名不能为空"),
    PASSWORD_NULL(UserExpPrefix+"001","密码不能为空"),
    AUTH_NULL(UserExpPrefix+"002","手机、电子邮件、用户名至少填一个"),
    LOGIN_FALL(UserExpPrefix+"003","登录失败"),
    UNLOGIN(UserExpPrefix+"004","尚未登录"),
    NO_PERMISSION(UserExpPrefix+"005","没有权限"),
    PHONE_NULL(UserExpPrefix+"006","手机号为空"),
    MAIL_NULL(UserExpPrefix+"007","电子邮件为空"),
    USERTYPE_NULL(UserExpPrefix+"008","用户类型为空"),
    LICENCE_NULL(UserExpPrefix+"009","营业执照为空"),
    COMPANYNAME_NULL(UserExpPrefix+"010","企业名称为空"),
    ROLE_NULL(UserExpPrefix+"011","角色为空"),
    ROLEID_NULL(UserExpPrefix+"012","roleId为空"),
    MENULIST_NULL(UserExpPrefix+"013","menulist为空"),
    PERMISSIONIDLIST_NULL(UserExpPrefix+"014","permissionIdList为空"),
    NAME_NULL(UserExpPrefix+"015","name为空"),
    LOCATIONID_NULL(UserExpPrefix+"016","locationId为空"),
    LOCATIONUPDATEREQ_NULL(UserExpPrefix+"017","LocationUpdateReq为空");


    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    private ExpCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
