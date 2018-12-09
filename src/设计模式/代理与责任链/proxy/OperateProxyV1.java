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
public class OperateProxyV1 implements InvocationHandler {

    private Operate operate;

    public OperateProxyV1(Operate operate) {
        this.operate = operate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("操作前");
        Object o;
        //注意 这是个可变参数方法
        o = method.invoke(operate, args);
        System.out.println("操作后");
        return o;
    }

    public static void main(String[] args) {
        Operate operate = new OperateImpl();
        operate = (Operate) Proxy.newProxyInstance(Operate.class.getClassLoader(), new Class[]{Operate.class}, new OperateProxyV1(operate));
        operate.doSelect();
    }
}
