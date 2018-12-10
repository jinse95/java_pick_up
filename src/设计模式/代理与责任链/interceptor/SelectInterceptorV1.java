package 设计模式.代理与责任链.interceptor;

/**
 * created on 2018/12/9
 *
 * @author J
 **/
public class SelectInterceptorV1 implements InterceptorV1 {
    @Override
    public void before() {
        System.out.println("Select之前");
    }

    @Override
    public void after() {
        System.out.println("Select之后");
    }
}
