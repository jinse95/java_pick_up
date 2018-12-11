package 设计模式.代理与责任链.proxy;

import 设计模式.代理与责任链.Invocation;
import 设计模式.代理与责任链.Operate;
import 设计模式.代理与责任链.OperateImpl;
import 设计模式.代理与责任链.interceptor.InterceptorV3;
import 设计模式.代理与责任链.interceptor.LogInterceptorV3;
import 设计模式.代理与责任链.interceptor.SelectInterceptorV3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * created on 2018/12/7.
 *
 * @author J
 **/
public class OperateProxyV6 implements InvocationHandler {

    private Operate operateProxy;

    private InterceptorV3 interceptor;

    public OperateProxyV6(Operate operateProxy, InterceptorV3 interceptor) {
        this.operateProxy = operateProxy;
        this.interceptor = interceptor;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Invocation invocation = new Invocation(operateProxy, method, args);
        Object o = interceptor.before(invocation);
        o = interceptor.after(invocation, o);
        return o;
    }

    public static Operate proxy(Operate op, InterceptorV3 interceptorV2) {
        return (Operate) Proxy.newProxyInstance(Operate.class.getClassLoader(), new Class[]{Operate.class}, new OperateProxyV6(op, interceptorV2));
    }


    public static void main(String[] args) {
        Operate operate = new OperateImpl();
        List<InterceptorV3> v2List = new ArrayList<>();
        v2List.add(new SelectInterceptorV3());
        v2List.add(new LogInterceptorV3());
        ChainManagerV3 chainManager = new ChainManagerV3(v2List);
        operate = chainManager.chain(operate);

        operate.doDelete();
        System.out.println("==========================");
        operate.doSelect();
    }
}
