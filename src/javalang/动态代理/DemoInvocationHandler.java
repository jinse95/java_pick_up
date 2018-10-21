package javalang.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author J
 * @time 2018/10/17 22:41
 * @description
 **/
public class DemoInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }

    public static void main(String[] args) {
        char a = '测';
        System.out.println(a);
    }
}
