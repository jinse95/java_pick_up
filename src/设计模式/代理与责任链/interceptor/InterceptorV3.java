package 设计模式.代理与责任链.interceptor;

import 设计模式.代理与责任链.Invocation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * created on 2018/12/9
 *
 * @author J
 **/
public interface InterceptorV3 {
    Object before(Invocation invocation) throws InvocationTargetException, IllegalAccessException, UndeclaredThrowableException;

    default Object after(Invocation invocation, Object result) {
        return result;
    }
}
