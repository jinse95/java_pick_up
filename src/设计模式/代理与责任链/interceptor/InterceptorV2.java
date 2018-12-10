package 设计模式.代理与责任链.interceptor;

import 设计模式.代理与责任链.Invocation;

/**
 * created on 2018/12/9
 *
 * @author J
 **/
public interface InterceptorV2 {
    /**
     * 操作前拦截
     */
    void before(Invocation invocation);

    /**
     * 操作后拦截
     * 可能需要对操作结果进行处理
     *
     * @param result 操作返回结果
     */
    default Object after(Invocation invocation, Object result) {
        return result;
    }
}
