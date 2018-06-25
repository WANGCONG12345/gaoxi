package com.gaoxi.gaoxiuser.dao;

import com.gaoxi.gaoxicommonservicefacade.entity.user.UserEntity;
import com.gaoxi.gaoxicommonservicefacade.req.user.UserQueryReq;

import java.util.List;

public interface UserDao {
    List<UserEntity> findUsers(UserQueryReq userQueryReq);
}
