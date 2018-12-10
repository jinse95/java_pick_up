package 设计模式.代理与责任链.proxy0;

import 设计模式.代理与责任链.Invocation;
import 设计模式.代理与责任链.Operate;
import 设计模式.代理与责任链.OperateImpl;
import 设计模式.代理与责任链.interceptor.*;

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
public class OperateProxyV5_2 implements InvocationHandler {

    private Operate operateProxy;

    private InterceptorV2 interceptor;

    public OperateProxyV5_2(Operate operateProxy, InterceptorV2 interceptor) {
        this.operateProxy = operateProxy;
        this.interceptor = interceptor;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Invocation invocation = new Invocation(operateProxy, method, args);
        interceptor.before(invocation);
        Object o = method.invoke(operateProxy,args);
        return interceptor.after(invocation,o);
    }

    public static Operate proxy(Operate op, InterceptorV2 interceptor) {
        return (Operate) Proxy.newProxyInstance(Operate.class.getClassLoader(), new Class[]{Operate.class}, new OperateProxyV5_2(op, interceptor));
    }

    public static void main(String[] args) {
        Operate operate = new OperateImpl();


        List<InterceptorV2> interceptorList = new ArrayList<>();
        interceptorList.add(new LogInterceptorV2());
        interceptorList.add(new SelectInterceptorV2());

        ChainManagerV1 managerV1 = new ChainManagerV1(interceptorList);
//        managerV1.addInterceptor(new LogInterceptorV2());
//        managerV1.addInterceptor(new SelectInterceptorV2());
        operate = managerV1.manage(operate);

        interceptorList.remove(1);
        operate.doSelect();
        System.out.println("==========================");
        operate.doDelete();
    }
}
