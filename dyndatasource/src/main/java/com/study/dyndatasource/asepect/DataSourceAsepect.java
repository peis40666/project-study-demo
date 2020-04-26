package com.study.dyndatasource.asepect;

import com.study.dyndatasource.config.DynamicDataSourceConfig;
import com.study.dyndatasource.statics.service.OrderService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Component
@Aspect
public class DataSourceAsepect {


    @Autowired
    private DynamicDataSourceConfig config;

    @Pointcut("@annotation(com.study.dyndatasource.annotation.DsAnnotation)")
    public void pointCut(){

    }

    @Around(value = "pointCut()")
    public Object switchDataSource(ProceedingJoinPoint point) throws Throwable {
        System.out.println("切换数据源");
      //  config.router(createTime);
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        final Object[] args = point.getArgs();//参数
        for(int i=0;i<args.length;i++){
          //  System.out.println(args);
            Class clazz = args[0].getClass();
            Field[] fields = clazz.getDeclaredFields();
            for(Field field:fields){
                if(field.getName().equalsIgnoreCase("createTime")){  //这一段需要做约定，必须有数据类型为Long的名为createTime的属性
                    field.setAccessible(true);
                    config.router(getOddOrEven((Long) field.get(args[i])));
                }
            }
        }
        return point.proceed();
    }


    /**
     * 判断是奇数还是偶数
     * 奇数返回1
     * 偶数返回2
     * @param x
     * @return
     */
    private int getOddOrEven(Long x){
        if(x % 2 == 0){
            return 2;
        }
        return 1;
    }
}
