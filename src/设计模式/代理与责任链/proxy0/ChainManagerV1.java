package 设计模式.代理与责任链.proxy0;

import 设计模式.代理与责任链.interceptor.InterceptorV2;
import 设计模式.代理与责任链.Operate;

import java.util.ArrayList;
import java.util.List;

/**
 * created on 2018/12/9
 *
 * @author J
 **/
public class ChainManagerV1 {

    private List<InterceptorV2> interceptorList;

    public ChainManagerV1() {
        interceptorList = new ArrayList<>();
    }

    public ChainManagerV1(List<InterceptorV2> interceptorList) {
        this.interceptorList = interceptorList;
    }

    public void addInterceptor(InterceptorV2 interceptorV3) {
        interceptorList.add(interceptorV3);
    }

    public Operate manage(Operate operate) {
        for (InterceptorV2 item : interceptorList) {
            operate = OperateProxyV5_2.proxy(operate, item);
        }
        return operate;
    }
}
