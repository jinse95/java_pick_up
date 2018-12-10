package 设计模式.代理与责任链.proxy0;

import 设计模式.代理与责任链.interceptor.InterceptorV3;
import 设计模式.代理与责任链.Operate;

import java.util.ArrayList;
import java.util.List;

/**
 * created on 2018/12/9
 *
 * @author J
 **/
public class ChainManagerV2 {

    private List<InterceptorV3> interceptorList;

    public ChainManagerV2() {
        interceptorList = new ArrayList<>();
    }

    public ChainManagerV2(List<InterceptorV3> interceptorList) {
        this.interceptorList = interceptorList;
    }

    public void addInterceptor(InterceptorV3 interceptorV3) {
        this.interceptorList.add(interceptorV3);
    }

    public Operate chain(Operate operate) {
        for (InterceptorV3 interceptorV2 : interceptorList) {
            operate = OperateProxyV6.proxy(operate, interceptorV2);
        }
        return operate;
    }
}
