package javalang.引用;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * created on 2019/1/26.
 *
 * @author J
 **/
public class WeakReferenceTest {
    public static void main(String[] args) {

        ReferenceQueue queue = new ReferenceQueue();
        String hl = new String("hello");
        WeakReference<String> sr = new WeakReference<>(hl);
        System.out.println(sr.get());
        hl = null;
        System.gc();//通知JVM的gc进行垃圾回收
        System.out.println(sr.get());
    }
}
