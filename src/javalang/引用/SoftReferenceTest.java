package javalang.引用;

import java.lang.ref.SoftReference;

/**
 * created on 2019/1/26.
 *
 * @author J
 **/
public class SoftReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        SoftReference<String> sr = new SoftReference<>("hello");
        System.out.println(sr.get());
        System.gc();//通知JVM的gc进行垃圾回收
        System.out.println(sr.get());
//        testGC();
    }


//    private static void testGC() {
//        SoftReference<MyObj> sr = new SoftReference<>(new MyObj("SoftReference"));
//        System.out.println(sr.get());
//        MyObj myObj = new MyObj("new");
//        System.out.println(sr.get());
//        System.out.println(myObj);
//    }
//
//
//    static class MyObj {
//        public Object[] objects;
//        public String name;
//
//        public MyObj(String name) {
//            this.objects = new Object[120000];
//            this.name = name;
//        }
//
//        @Override
//        public String toString() {
//            return "MyObj{" +
//                    "name='" + name + '\'' +
//                    '}';
//        }
//    }
}
