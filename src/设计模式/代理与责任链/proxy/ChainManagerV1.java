package 设计模式.代理与责任链.proxy;

import 设计模式.代理与责任链.Operate;
import 设计模式.代理与责任链.interceptor.InterceptorV1;

import java.util.ArrayList;
import java.util.List;

/**
 * created on 2018/12/9
 *
 * @author J
 **/
public class ChainManagerV1 {

    private List<InterceptorV1> interceptorList;

    public ChainManagerV1() {
        interceptorList = new ArrayList<>();
    }

    public ChainManagerV1(List<InterceptorV1> interceptorList) {
        this.interceptorList = interceptorList;
    }

    public void addInterceptor(InterceptorV1 interceptorV1) {
        interceptorList.add(interceptorV1);
    }

    public Operate manage(Operate operate) {
        for (InterceptorV1 item : interceptorList) {
            operate = OperateProxyV4.proxy(operate, item);
        }
        return operate;
    }
}
