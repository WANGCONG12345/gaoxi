package com.gaoxi.gaoxicommonservicefacade;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestCommon {
    public static void doSomeThing(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.err.println("当前时间是："+dateFormat.format(new Date()));
        System.err.println("There test a jar package how to be achieved");
    }

    public static void main(String[] args) {
        doSomeThing();
    }
}
