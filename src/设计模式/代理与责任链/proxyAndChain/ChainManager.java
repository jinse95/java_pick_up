package 设计模式.代理与责任链.proxyAndChain;

import 设计模式.代理与责任链.InterceptorV2;
import 设计模式.代理与责任链.Operate;

import java.util.List;

/**
 * created on 2018/12/9
 *
 * @author J
 **/
public class ChainManager {

    private List<InterceptorV2> interceptorList;

    public ChainManager(List<InterceptorV2> interceptorList) {
        this.interceptorList = interceptorList;
    }

    public Operate manage(Operate operate) {
        for (InterceptorV2 interceptorV2 : interceptorList) {
            operate = OperateProxyV5.proxy(operate,interceptorV2);
        }
        return operate;
    }
}
