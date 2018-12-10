package 设计模式.代理与责任链.proxy;

import 设计模式.代理与责任链.Operate;
import 设计模式.代理与责任链.OperateImpl;
import 设计模式.代理与责任链.interceptor.InterceptorV1;
import 设计模式.代理与责任链.interceptor.LogInterceptorV1;
import 设计模式.代理与责任链.interceptor.SelectInterceptorV1;

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

    private InterceptorV1 interceptor;

    public OperateProxyV4(Operate operateProxy, InterceptorV1 interceptor) {
        this.operateProxy = operateProxy;
        this.interceptor = interceptor;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        boolean needIntercept = interceptor instanceof SelectInterceptorV1 && "doSelect".equals(method.getName());
        if (needIntercept){
            interceptor.before();
        }
        Object o  = method.invoke(operateProxy, args);
        if (needIntercept){
            interceptor.after();
        }
        return o;
    }

    public static Operate proxy(Operate op, InterceptorV1 interceptor) {
        return (Operate) Proxy.newProxyInstance(Operate.class.getClassLoader(), new Class[]{Operate.class}, new OperateProxyV4(op, interceptor));
    }

    public static void main(String[] args) {
        Operate operate = new OperateImpl();
        ChainManagerV1 managerV1 = new ChainManagerV1();
        managerV1.addInterceptor(new LogInterceptorV1());
        managerV1.addInterceptor(new SelectInterceptorV1());
        operate = managerV1.manage(operate);
        operate.doSelect();
    }
}
