package com.gaoxi.gaoxiuser.facade.user;

import com.gaoxi.gaoxiuser.entity.user.UserEntity;
import com.gaoxi.gaoxiuser.req.user.LoginReq;

/**
 * @author acong
 * @date 2018年6月8日14:50:33
 * @description
 */
public interface UserService {

 public UserEntity login(LoginReq loginReq);
}
