package com.easy.view.utils;

import android.view.View;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by shishufeng on 2021/6/22
 * desc: 快速点击切面类
 */
@Aspect
public class FastCheckerClickAspect {


    @Pointcut("execution(void android.view.View.OnClickListener.onClick(..))")
    public void methodOnViewClick(){

    }


    @Around("methodOnViewClick()")
    public void aroundMethodOnViewClick(ProceedingJoinPoint point) throws Throwable{
        View target = (View) point.getArgs()[0];
        if (!CheckFastClick.isFastClick(target,2000)){
            point.proceed();
        }
    }
}
