package 设计模式.代理与责任链.interceptor;

/**
 * created on 2018/12/9
 *
 * @author J
 **/
public class LogInterceptorV1 implements InterceptorV1 {
    @Override
    public void before() {
        System.out.println("操作前日志记录");
    }

    @Override
    public void after() {
        System.out.println("操作后日志记录");
    }
}
