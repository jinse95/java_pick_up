package 设计模式.代理与责任链.proxy;

import 设计模式.代理与责任链.InterceptorV1;

/**
 * created on 2018/12/9
 *
 * @author J
 **/
public class Interceptor2 implements InterceptorV1 {
    @Override
    public void before() {
        System.out.println("自定义的操作前2");
    }

    @Override
    public void after() {
        System.out.println("自定义的操作后2");
    }
}
