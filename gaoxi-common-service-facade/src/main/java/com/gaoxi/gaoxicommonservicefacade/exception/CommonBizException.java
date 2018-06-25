package com.gaoxi.gaoxicommonservicefacade.exception;

import java.io.Serializable;

/**
 * @author acong
 * @2018年6月14日17:52:34
 * @description 通用业务异常
 */
public class CommonBizException extends RuntimeException implements Serializable {
    private ExpCodeEnum codeEnum;

    public CommonBizException( ExpCodeEnum codeEnum) {
        super(codeEnum.getMessage());
        this.codeEnum = codeEnum;
    }

    public CommonBizException() {

    }

    public ExpCodeEnum getCodeEnum() {
        return codeEnum;
    }
}
