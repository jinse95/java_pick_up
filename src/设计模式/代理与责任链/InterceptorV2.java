package 设计模式.代理与责任链;

import 设计模式.代理与责任链.proxy.OperateProxyV4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * created on 2018/12/9
 *
 * @author J
 **/
public interface InterceptorV2 {
    Object before(Invocation invocation) throws InvocationTargetException, IllegalAccessException, UndeclaredThrowableException;

    Object after(Invocation invocation, Object result);

    default Operate register(Operate target) {
        return OperateProxyV4.proxy(target, this);
    }
}
