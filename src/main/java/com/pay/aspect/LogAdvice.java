package com.pay.aspect;

import com.google.gson.Gson;
import com.pay.entity.ZcLog;
import com.pay.service.impl.ZcLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * create by wenjie.mao
 * Date: 2019/9/19
 */
@Aspect
@Component
public class LogAdvice {

    @Autowired
    private ZcLogService zcLogService;

    private ExecutorService es = Executors.newFixedThreadPool(3);


    @Pointcut("execution(* com.pay.controller.*.*(..))")
    public void pointCut() {
    }

    /**
     * 环绕通知 @Around
     *
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        final long beginTime = System.currentTimeMillis();
        Object result;
        try {
            result = point.proceed();
            final long time = System.currentTimeMillis() - beginTime;
            es.submit(()->{
                saveLog(point, time, result);
            });
        } catch (Exception e) {
            final long time = System.currentTimeMillis() - beginTime;
            es.submit(()-> {
                saveLog(point, time, e.getMessage());
            });
            throw e;
        }
        return result;
    }

    /**
     * 保存日志
     *
     * @param joinPoint
     * @param time
     * @param result
     */
    private void saveLog(ProceedingJoinPoint joinPoint, long time, Object result) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        ZcLog zcLog = new ZcLog();
        zcLog.setRequestTime(time);
        zcLog.setCreateTime(new Date());

        //请求的 类名、方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        zcLog.setRequestMethodName(className + "." + methodName);
        //请求的参数
        Object[] args = joinPoint.getArgs();
        try {
            List<String> list = new ArrayList<String>();
            for (Object o : args) {
                list.add(new Gson().toJson(o));
            }
            zcLog.setRequestArgs(list.toString());
            if (null != result) {
                zcLog.setRequestResponse(new Gson().toJson(result));
            }
        } catch (Exception e) {
        }

        zcLogService.insert(zcLog);
    }
}