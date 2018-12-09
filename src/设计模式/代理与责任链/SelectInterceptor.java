package 设计模式.代理与责任链;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * created on 2018/12/9
 *
 * @author J
 **/
public class SelectInterceptor implements InterceptorV2 {


    @Override
    public Object before(Invocation invocation) throws InvocationTargetException, IllegalAccessException, UndeclaredThrowableException {
        if ("doSelect".equals(invocation.getMethod().getName())) {
            System.out.println("查询拦截 - 操作前");
        }
        return invocation.proceed();
    }

    @Override
    public Object after(Invocation invocation, Object result) {
        if ("doSelect".equals(invocation.getMethod().getName())) {
            System.out.println("查询拦截 - 操作后");
        }
        return result;
    }
}
