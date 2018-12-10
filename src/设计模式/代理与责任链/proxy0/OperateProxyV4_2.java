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
public class OperateProxyV4_2 implements InvocationHandler {

    private Operate operateProxy;

    private List<InterceptorV1> interceptors;

    public OperateProxyV4_2(Operate operateProxy, List<InterceptorV1> interceptors) {
        this.operateProxy = operateProxy;
        this.interceptors = interceptors;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        boolean isSelect = "doSelect".equals(method.getName());
        int len = interceptors.size();
        for (int i = 0; i < len; i++) {
            InterceptorV1 item = interceptors.get(i);
            if (item instanceof SelectInterceptorV1) {
                if (isSelect) {
                    item.before();
                }
            } else {
                item.before();
            }
        }
        Object o = method.invoke(operateProxy, args);
        for (int i = len - 1; i >= 0; i--) {
            InterceptorV1 item = interceptors.get(i);
            if (item instanceof SelectInterceptorV1) {
                if (isSelect) {
                    item.before();
                }
            } else {
                item.after();
            }
        }
        return o;
    }

    public static Operate proxy(Operate op, List<InterceptorV1> interceptor) {
        return (Operate) Proxy.newProxyInstance(Operate.class.getClassLoader(), new Class[]{Operate.class}, new OperateProxyV4_2(op, interceptor));
    }

    public static void main(String[] args) {
        Operate operate = new OperateImpl();
        List<InterceptorV1> interceptorV1List = new ArrayList<>();
        interceptorV1List.add(new SelectInterceptorV1());
        interceptorV1List.add(new LogInterceptorV1());

        operate = OperateProxyV4_2.proxy(operate, interceptorV1List);
        operate.doDelete();
        System.out.println("==========================");
        operate.doSelect();
    }
}
