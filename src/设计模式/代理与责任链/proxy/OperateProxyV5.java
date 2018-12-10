package 设计模式.代理与责任链.proxy;

import 设计模式.代理与责任链.Invocation;
import 设计模式.代理与责任链.Operate;
import 设计模式.代理与责任链.OperateImpl;
import 设计模式.代理与责任链.interceptor.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * created on 2018/12/7.
 *
 * @author J
 **/
public class OperateProxyV5 implements InvocationHandler {

    private Operate operateProxy;

    private InterceptorV2 interceptor;

    public OperateProxyV5(Operate operateProxy, InterceptorV2 interceptor) {
        this.operateProxy = operateProxy;
        this.interceptor = interceptor;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Invocation invocation = new Invocation(operateProxy,method,args);
        interceptor.before(invocation);
        Object o = method.invoke(operateProxy, args);
        return interceptor.after(invocation,o);
    }

    public static Operate proxy(Operate op, InterceptorV2 interceptor) {
        return (Operate) Proxy.newProxyInstance(Operate.class.getClassLoader(), new Class[]{Operate.class}, new OperateProxyV5(op, interceptor));
    }

    public static void main(String[] args) {
        Operate operate = new OperateImpl();
        ChainManagerV2 managerV2 = new ChainManagerV2();
        managerV2.addInterceptor(new SelectInterceptorV2());
        managerV2.addInterceptor(new LogInterceptorV2());
        operate = managerV2.manage(operate);
        operate.doSelect();
    }
}
