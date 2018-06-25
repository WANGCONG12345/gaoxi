package com.gaoxi.gaoxiuser.service;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.gaoxi.gaoxicommonservicefacade.entity.user.UserEntity;
import com.gaoxi.gaoxicommonservicefacade.exception.CommonBizException;
import com.gaoxi.gaoxicommonservicefacade.exception.ExpCodeEnum;
import com.gaoxi.gaoxicommonservicefacade.facade.user.UserService;
import com.gaoxi.gaoxicommonservicefacade.req.user.LoginReq;
import com.gaoxi.gaoxicommonservicefacade.req.user.UserQueryReq;
import com.gaoxi.gaoxiuser.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version ="1.0.0")
@org.springframework.stereotype.Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    private static final String USER_KEY_PREFIX = "USER";
    @Override
    public UserEntity login(LoginReq loginReq) {
        //校验参数
        checkParam(loginReq);
        //创建用户查询请求
        UserQueryReq userQueryReq = buildUserQueryReq(loginReq);
        //查询用户
        List<UserEntity> userEntityList = userDao.findUsers(userQueryReq);
        //查询失败
        if (CollectionUtils.isEmpty(userEntityList)){
            throw new CommonBizException(ExpCodeEnum.LOGIN_FALL);
        }

        return userEntityList.get(0);
    }

    /**
     * 构造用户查询对象
     * @param loginReq 登录请求
     * @return 用户查询请求对象
     */
    private UserQueryReq buildUserQueryReq(LoginReq loginReq) {
        UserQueryReq userQueryReq = new UserQueryReq();
        userQueryReq.setPassword(loginReq.getPassword());
        if (StringUtils.isNotEmpty(loginReq.getUsername())){
            userQueryReq.setUsername(loginReq.getUsername());
        }
        if (StringUtils.isNotEmpty(loginReq.getPhone())){
            userQueryReq.setPhone(loginReq.getPhone());
        }
        if (StringUtils.isNotEmpty(loginReq.getEmail())){
            userQueryReq.setMail(loginReq.getEmail());
        }
        return userQueryReq;
    }

    /**
     * 参数校验
     * @param loginReq
     */
    private void checkParam(LoginReq loginReq) {
        //密码不能为空
        if (StringUtils.isEmpty(loginReq.getPassword())){
            throw new CommonBizException(ExpCodeEnum.PASSWORD_NULL);
        }
        //手机号、用户名、mail至少填一个
        if (StringUtils.isEmpty(loginReq.getPhone())&&StringUtils.isEmpty(loginReq.getEmail())
         && StringUtils.isEmpty(loginReq.getUsername())){
            throw new CommonBizException(ExpCodeEnum.AUTH_NULL);
        }
    }
}
