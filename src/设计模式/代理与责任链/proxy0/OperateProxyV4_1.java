package 设计模式.代理与责任链.proxy0;

import 设计模式.代理与责任链.*;
import 设计模式.代理与责任链.interceptor.InterceptorV1;
import 设计模式.代理与责任链.interceptor.LogInterceptorV1;
import 设计模式.代理与责任链.interceptor.SelectInterceptorV1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * 若是需要定义一个拦截器只对select方法起作用
 * created on 2018/12/7.
 *
 * @author J
 **/
public class OperateProxyV4_1 implements InvocationHandler {

    private Operate operateProxy;

    private List<InterceptorV1> interceptors;

    public OperateProxyV4_1(Operate operateProxy, List<InterceptorV1> interceptors) {
        this.operateProxy = operateProxy;
        this.interceptors = interceptors;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        int len = interceptors.size();
        for (int i = 0; i < len; i++) {
            interceptors.get(i).before();
        }
        Object o = method.invoke(operateProxy, args);
        for (int i = len - 1; i >= 0; i--) {
            interceptors.get(i).after();
        }
        return o;
    }

    public static Operate proxy(Operate op, List<InterceptorV1> interceptor) {
        return (Operate) Proxy.newProxyInstance(Operate.class.getClassLoader(), new Class[]{Operate.class}, new OperateProxyV4_1(op, interceptor));
    }

    public static void main(String[] args) {
        Operate operate = new OperateImpl();
        List<InterceptorV1> interceptorV1List = new ArrayList<>();
        interceptorV1List.add(new LogInterceptorV1());
        interceptorV1List.add(new SelectInterceptorV1());

        operate = OperateProxyV4_1.proxy(operate, interceptorV1List);
        operate.doDelete();
        System.out.println("==========================");
        operate.doSelect();
    }
}
