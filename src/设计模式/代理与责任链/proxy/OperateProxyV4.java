package 设计模式.代理与责任链.proxy;

import 设计模式.代理与责任链.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * created on 2018/12/7.
 *
 * @author J
 **/
public class OperateProxyV4 implements InvocationHandler {

    private Operate operateProxy;

    private InterceptorV2 interceptor;

    public OperateProxyV4(Operate operateProxy, InterceptorV2 interceptor) {
        this.operateProxy = operateProxy;
        this.interceptor = interceptor;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Invocation invocation = new Invocation(operateProxy, method, args);
        Object o = interceptor.before(invocation);
        return interceptor.after(invocation, o);
    }

    public static Operate proxy(Operate op, InterceptorV2 interceptor) {
        return (Operate) Proxy.newProxyInstance(Operate.class.getClassLoader(), new Class[]{Operate.class}, new OperateProxyV4(op, interceptor));
    }

    public static void main(String[] args) {
        Operate operate = new OperateImpl();
        InterceptorV2 interceptor = new LogInterceptor();
        operate  = interceptor.register(operate);
//        operate = OperateProxyV4.proxy(operate, interceptor);
        operate.doSelect();
    }
}
