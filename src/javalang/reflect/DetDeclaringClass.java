package javalang.reflect;

import javalang.动态代理.Eat;
import javalang.动态代理.Man;

import java.lang.reflect.Method;

/**
 * created on 2019/3/7.
 *
 * @author J
 **/
public class DetDeclaringClass {

    public static void main(String[] args) {
        Eat eat = new Man();
        Method[] methods = eat.getClass().getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            //打印的是Man
            System.out.println(method.getDeclaringClass());
            System.out.println("=============");
        }
    }

}
