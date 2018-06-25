package com.gaoxi.gaoxicommonservicefacade.facade.user;


import com.gaoxi.gaoxicommonservicefacade.entity.user.UserEntity;
import com.gaoxi.gaoxicommonservicefacade.req.user.LoginReq;

/**
 * @author acong
 * @date 2018年6月8日14:50:33
 * @description
 */
public interface UserService {

 public UserEntity login(LoginReq loginReq);
}
