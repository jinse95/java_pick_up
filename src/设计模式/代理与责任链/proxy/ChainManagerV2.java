package 设计模式.代理与责任链.proxy;

import 设计模式.代理与责任链.Operate;
import 设计模式.代理与责任链.interceptor.InterceptorV1;
import 设计模式.代理与责任链.interceptor.InterceptorV2;

import java.util.ArrayList;
import java.util.List;

/**
 * created on 2018/12/9
 *
 * @author J
 **/
public class ChainManagerV2 {

    private List<InterceptorV2> interceptorList;

    public ChainManagerV2() {
        interceptorList = new ArrayList<>();
    }

    public ChainManagerV2(List<InterceptorV2> interceptorList) {
        this.interceptorList = interceptorList;
    }

    public void addInterceptor(InterceptorV2 interceptorV2) {
        interceptorList.add(interceptorV2);
    }

    public Operate manage(Operate operate) {
        for (InterceptorV2 item : interceptorList) {
            operate = OperateProxyV5.proxy(operate, item);
        }
        return operate;
    }
}
