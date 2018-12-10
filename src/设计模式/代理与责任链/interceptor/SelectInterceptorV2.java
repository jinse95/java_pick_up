package 设计模式.代理与责任链.interceptor;

import 设计模式.代理与责任链.Invocation;

/**
 * created on 2018/12/9
 *
 * @author J
 **/
public class SelectInterceptorV2 implements InterceptorV2 {


    @Override
    public void before(Invocation invocation) {
        if ("doSelect".equals(invocation.getMethod().getName())) {
            System.out.println("查询拦截 - 操作前");
        }
    }

    @Override
    public Object after(Invocation invocation, Object result) {
        if ("doSelect".equals(invocation.getMethod().getName())) {
            System.out.println("查询拦截 - 操作后");
        }
        return result;
    }
}
