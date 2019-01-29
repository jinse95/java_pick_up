package javalang.base;

/**
 * created on 2019/1/26.
 *
 * @author J
 **/
class Price {
    /**
     * 类加载过程
     * <p>
     * 1. 加载  将编译完成的class字节码文件加载进内存(双亲委派模型 自定义类加载器)
     * 2. 验证  验证加载的内容是否符合虚拟机规范(这部分一般不需要了解)
     * 3. 准备: 为类变量分配内存并设置类变量初始值(“通常情况” 下初始值是零值，引用类型为null)
     * ~        同时被final和static修饰的字段具有ConstantValue属性,在准备阶段被赋值为ConstantValue，仅限于基本类型和String
     * 4. 解析: 将常量池的符号引用替换为直接引用
     * 5. 初始化: 给类变量赋值,执行static代码块,(父类优先于子类,按源文件中的语句顺序执行)
     */

    //这两行换一下就不一样了
    //此处的P是对象,即使同时被statis final同时修饰,但是也和 INIT_PRICE 一样在初始化阶段 赋值
    public static final Price P = new Price(1);
    public static double INIT_PRICE = 10;

    double currentPrice;

    public Price(double discount) {
        currentPrice = INIT_PRICE - discount;
    }
}

class InitTimeParent {
    /**
     * 子类初始化会触发父类初始化
     */
    static {
        System.out.println("parent Class <init>");
    }
}

class InitTime extends InitTimeParent {
    /**
     * 类初始化的时机
     * 1. 遇到new、getstatic、putstatic或invokestatic这4条字节码指令时，如果类没有进行过初始化，则需要先触发其初始化。
     * ~  生成这4条指令的最常见的Java代码场景是：
     * 1.1  使用new关键字实例化对象的时候、
     * 1.2  读取或设置一个类的静态字段（被final修饰、已在编译期把结果放入常量池的静态字段除外）的时候，
     * 1.3  以及调用一个类的静态方法的时候。
     * <p>
     * 2. 使用java.lang.reflect包的方法对类进行反射调用的时候，如果类没有进行过初始化，则需要先触发其初始化。
     * 3. 当初始化一个类的时候，如果发现其父类还没有进行过初始化，则需要先触发其父类的初始化。
     * 4. 当虚拟机启动时，用户需要指定一个要执行的主类（包含main（）方法的那个类），虚拟机会先初始化这个主类。
     * 5. 当使用JDK 1.7的动态语言支持时，如果一个java.lang.invoke.MethodHandle实例最后的解析结果REF_getStatic、REF_putStatic、REF_invokeStatic的方法句柄，并且这个方法句柄所对应的类没有进行过初始化，则需要先触发其初始化
     */
    public static final int n1 = 1;
    public static int n2 = 2;
    public int n = 0;

    static {
        System.out.println("<init>");
    }

    public static void staticMethod() {
        System.out.println("static Method");
    }
}

public class ReferenceSelf {
    /**
     * main方法所在的类会触发初始化
     */
    static {
        System.out.println("main Class <init>");
    }

    public static void main(String[] args) {
        //输出 main Class <init> 子类初始化
        //输出 -1.0 (详见 Price 类加载过程)
        System.out.println(Price.P.currentPrice);

        System.out.println();
        System.out.println("====================");
        System.out.println();

        //输出 1
        System.out.println(InitTime.n1);
        //输出 parent Class <init> 先触发父类的初始化
        //输出 <init>
        //输出 2 (因为此处会触发初始化)
        System.out.println(InitTime.n2);
        //输出 static Method (由于前面输出2已经触发了初始化)
        InitTime.staticMethod();
    }

}
