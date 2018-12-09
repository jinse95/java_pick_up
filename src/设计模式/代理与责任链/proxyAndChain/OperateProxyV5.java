package 设计模式.代理与责任链.proxyAndChain;

import 设计模式.代理与责任链.*;

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
public class OperateProxyV5 implements InvocationHandler {

    private Operate operateProxy;

    private InterceptorV2 interceptor;

    public OperateProxyV5(Operate operateProxy, InterceptorV2 interceptor) {
        this.operateProxy = operateProxy;
        this.interceptor = interceptor;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object o;
        o = interceptor.before(
                new Invocation(operateProxy, method, args)
        );

        o = interceptor.after(
                new Invocation(operateProxy, method, args)
                , o
        );

        return o;
    }

    public static Operate proxy(Operate op, InterceptorV2 interceptorV2) {
        return (Operate) Proxy.newProxyInstance(Operate.class.getClassLoader(), new Class[]{Operate.class}, new OperateProxyV5(op, interceptorV2));
    }


    public static void main(String[] args) {
        Operate operate = new OperateImpl();
        List<InterceptorV2> v2List = new ArrayList<>();
        v2List.add(new SelectInterceptor());
        v2List.add(new LogInterceptor());
        ChainManager chainManager = new ChainManager(v2List);
        operate = chainManager.manage(operate);

        operate.doSelect();
    }
}
