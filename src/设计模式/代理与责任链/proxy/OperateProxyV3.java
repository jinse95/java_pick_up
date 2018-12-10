package 设计模式.代理与责任链.proxy;

import 设计模式.代理与责任链.interceptor.InterceptorV1;
import 设计模式.代理与责任链.interceptor.LogInterceptorV1;
import 设计模式.代理与责任链.Operate;
import 设计模式.代理与责任链.OperateImpl;
import 设计模式.代理与责任链.interceptor.SelectInterceptorV1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * created on 2018/12/7.
 *
 * @author J
 **/
public class OperateProxyV3 implements InvocationHandler {

    private Operate operateProxy;

    private InterceptorV1 interceptor;

    public OperateProxyV3(Operate operateProxy, InterceptorV1 interceptor) {
        this.operateProxy = operateProxy;
        this.interceptor = interceptor;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        interceptor.before();
        Object o  = method.invoke(operateProxy, args);
        interceptor.after();
        return o;
    }

    public static Operate proxy(Operate op, InterceptorV1 interceptor) {
        return (Operate) Proxy.newProxyInstance(Operate.class.getClassLoader(), new Class[]{Operate.class}, new OperateProxyV3(op, interceptor));
    }

    public static void main(String[] args) {
        Operate operate = new OperateImpl();
        operate = OperateProxyV3.proxy(operate, new LogInterceptorV1());
        operate = OperateProxyV3.proxy(operate,new SelectInterceptorV1());
        operate.doSelect();
    }
}
