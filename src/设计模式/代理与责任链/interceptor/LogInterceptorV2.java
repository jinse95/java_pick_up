package 设计模式.代理与责任链.interceptor;

import 设计模式.代理与责任链.Invocation;

/**
 * created on 2018/12/9
 *
 * @author J
 **/
public class LogInterceptorV2 implements InterceptorV2 {


    @Override
    public void before(Invocation invocation){
        System.out.println("记录日志 - 操作前");
    }

    @Override
    public Object after(Invocation invocation,Object result) {
        System.out.println("记录日志 - 操作后");
        return result;
    }
}
