package 设计模式.代理与责任链.proxy0;

import 设计模式.代理与责任链.*;
import 设计模式.代理与责任链.interceptor.InterceptorV2;
import 设计模式.代理与责任链.interceptor.LogInterceptorV2;
import 设计模式.代理与责任链.interceptor.SelectInterceptorV2;

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
public class OperateProxyV5_1 implements InvocationHandler {

    private Operate operateProxy;

    private List<InterceptorV2> interceptors;

    public OperateProxyV5_1(Operate operateProxy, List<InterceptorV2> interceptors) {
        this.operateProxy = operateProxy;
        this.interceptors = interceptors;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Invocation invocation = new Invocation(operateProxy, method, args);
        int len = interceptors.size();
        for (int i = 0; i < len; i++) {
            interceptors.get(i).before(invocation);
        }
        Object o  = method.invoke(operateProxy, args);
        for (int i = len - 1; i >= 0; i--) {
            o = interceptors.get(i).after(invocation, o);
        }
        return o;
    }

    public static Operate proxy(Operate op, List<InterceptorV2> interceptor) {
        return (Operate) Proxy.newProxyInstance(Operate.class.getClassLoader(), new Class[]{Operate.class}, new OperateProxyV5_1(op, interceptor));
    }

    public static void main(String[] args) {
        Operate operate = new OperateImpl();
        List<InterceptorV2> interceptorList = new ArrayList<>();
        interceptorList.add(new LogInterceptorV2());
        interceptorList.add(new SelectInterceptorV2());
//        ChainManagerV1 managerV1 = new ChainManagerV1();
//        managerV1.addInterceptor(new LogInterceptorV2());
//        managerV1.addInterceptor(new SelectInterceptorV2());
//        operate = managerV1.manage(operate);
        operate = OperateProxyV5_1.proxy(operate, interceptorList);

        operate.doSelect();
        System.out.println("==========================");
        operate.doDelete();
    }
}
