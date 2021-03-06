package javalang.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author J
 * @time 2018/10/24 22:29
 * @description
 **/
public class ProxyTest {

    public static void main(String[] args) {
        //静态代理
        Eat eat = new EatStaticProxy(new Man());
        eat.eatFood("米饭");

        System.out.println("======================");

        //动态代理
        Eat eat1 = new Man();
        Dress dress0 = new Man();
        InvocationHandler handler = new DynamicProxy(eat1);
        Eat eat2 = (Eat) Proxy.newProxyInstance(Eat.class.getClassLoader(), new Class[]{Eat.class}, handler);
        eat2.eatFood("面");

        System.out.println("======================");

        handler = new DynamicProxy(dress0);
        Dress dress = (Dress) Proxy.newProxyInstance(Dress.class.getClassLoader(), new Class[]{Dress.class}, handler);
        dress.dressClothes("夹克");

    }

}
