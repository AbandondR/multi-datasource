package com.database.multi.datasource.aspect;

import com.database.multi.datasource.annotation.DataSource;
import com.database.multi.datasource.config.DynamicDataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author Yu
 * @since 2020/4/5
 */
@Aspect
@Component
public class DataSourceAspect {

    @Pointcut("@annotation(com.database.multi.datasource.annotation.DataSource)")
    public void pointCut(){}


    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceed) throws Throwable {
        MethodSignature methodSignature = (MethodSignature)proceed.getSignature();
        Method method = methodSignature.getMethod();
        DataSource dataSource = method.getAnnotation(DataSource.class);
        DynamicDataSource.setDataSourceLookupKey(dataSource.name().equals("") ? "master_test" : dataSource.name());
        try {
            return proceed.proceed();
        }
        finally {
            DynamicDataSource.clear();
        }
    }
}
