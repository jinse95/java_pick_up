package 设计模式.代理与责任链.proxy;

import 设计模式.代理与责任链.InterceptorV1;

/**
 * created on 2018/12/9
 *
 * @author J
 **/
public class Interceptor1 implements InterceptorV1 {
    @Override
    public void before() {
        System.out.println("操作前");
    }

    @Override
    public void after() {
        System.out.println("操作后");
    }
}
