package cn.wenqi.aop;

import cn.wenqi.annocation.TargetDataSource;
import cn.wenqi.config.DataSourceContextHolder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author wenqi
 */
@Component
@Aspect
public class DataSourceSelector {

    private static final Log log= LogFactory.getLog(DataSourceSelector.class);

    @Around("execution(* cn.wenqi.service.impl.*.*(..))")
    public Object proceed(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method targetMethod = methodSignature.getMethod();
        if(targetMethod.isAnnotationPresent(TargetDataSource.class)){
            String targetDataSource = targetMethod.getAnnotation(TargetDataSource.class).value();
            log.info("当前选择的数据源是："+targetDataSource);
            DataSourceContextHolder.setDataSource(targetDataSource);
        }
        Object result = joinPoint.proceed();
        DataSourceContextHolder.clearDataSource();
        return result;
    }

}
