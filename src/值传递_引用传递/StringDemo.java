package 值传递_引用传递;

/**
 * @author J
 * @time 2018/1/3 22:29
 * @description
 **/
public class StringDemo {

    /**
     * c1==c2:false
     * c1.equals(c2):true
     * c3==c1:true
     * c1.equals(c3):true
     * han   abc
     * false
     * 一旦一个String对象在内存中创建，它将是不可改变的，所有的String类中方法并不是改变String对象自己，而是重新创建一个新的String对象。
     */
    public static void testString() {
        String c1 = new String("abc");
        String c2 = new String("abc");
        String c3 = c1;
        System.out.println("c1==c2:" + (c1 == c2));// false
        System.out.println("c1.equals(c2):" + c1.equals(c2)); //true
        System.out.println("c3==c1:" + (c3 == c1)); //true
        System.out.println("c1.equals(c3):" + c1.equals(c3)); // true
        c1 = "han";
        System.out.println(c1 + "   " + c3); //han   abc
        System.out.println("" + (c3 == c1)); //false
    }

    public static void foo1(String a) {
        a = a.substring(a.length() - 1);
        System.out.println("in foo1: " + a);
    }

    public static void foo2(StringBuilder builder) {
        builder = builder.append(" 23333");
        System.out.println("in foo2: " + builder);
    }

    public static void foo3(StringBuilder builder) {
        builder = new StringBuilder("23333");
        System.out.println("in foo3: " + builder);
    }

    public static void  foo4(){
        String str1 = "a";
        String str2 = "b";
        String str3 = "ab";
        String str4 = str1 + str2;
        String str5 = new String("ab");
        String str6 = "a"+"b";

        //值相等
        System.out.println(str5.equals(str3)); //true
        //引用不同 因为 str5 new了一个对象
        System.out.println(str5 == str3);  //false
        // str4又两个变量相加则生成一个新的对象
        System.out.println(str4 == str3);  //false
        // 字符常量相加先去字符串池找若存在则返回该对象的引用 指向同一个引用
        System.out.println(str6 == str3);  //true
        // 引用不同
        System.out.println(str6 == str4);  //false
        //str5.intern() 即去字符串池中去找str5值的字符串存在则直接返回引用,不存在则会将该字符串加入到字符串池再返回引用
        System.out.println(str5.intern() == str3); //true
        //引用不同
        System.out.println(str5.intern() == str4); //false
    }

    public static void testIntern(){
        String str1 = "abc";
        String str2 = new String("abc").intern();
        System.out.println(str1 == str2);
    }


    public static void main(String[] args) {

//        testString();
//
//        //String 不可变
//        //任何操作都会new 一个对象
//        String str = "test";
//        foo1(str);
//        System.out.println(str);
//
//
//        StringBuilder stringBuilder = new StringBuilder("test_append_builder");
//        foo2(stringBuilder);
//        System.out.println(stringBuilder);
//
//        StringBuilder newStringBuilder = new StringBuilder("test_new_builder");
//        foo3(newStringBuilder);
//        System.out.println(newStringBuilder);
//        foo4();
        testIntern();
    }
}
