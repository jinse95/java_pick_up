package 设计模式.代理与责任链;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * created on 2018/12/9
 *
 * @author J
 **/
public class LogInterceptor implements InterceptorV2 {


    @Override
    public Object before(Invocation invocation) throws InvocationTargetException, IllegalAccessException, UndeclaredThrowableException {
        System.out.println("记录日志 - 操作前");
        return invocation.proceed();
    }

    @Override
    public Object after(Invocation invocation, Object result) {
        System.out.println("记录日志 - 操作后");
        return result;
    }
}
