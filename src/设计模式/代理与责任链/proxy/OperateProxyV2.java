package 设计模式.代理与责任链.proxy;

import 设计模式.代理与责任链.Operate;
import 设计模式.代理与责任链.OperateImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * created on 2018/12/7.
 *
 * @author J
 **/
public class OperateProxyV2 implements InvocationHandler {

    private Operate operateProxy;

    public OperateProxyV2(Operate operate) {
        this.operateProxy = operate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("操作前");
        Object o = method.invoke(operateProxy, args);
        System.out.println("操作后");
        return o;
    }

    public static Operate proxy(Operate op) {
        return (Operate) Proxy.newProxyInstance(Operate.class.getClassLoader(), new Class[]{Operate.class}, new OperateProxyV2(op));
    }

    public static void main(String[] args) {
        Operate operate = new OperateImpl();
        operate = OperateProxyV2.proxy(operate);
        operate.doSelect();
    }
}
