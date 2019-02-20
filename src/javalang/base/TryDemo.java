package javalang.base;

/**
 * created on 2019/2/20.
 *
 * @author J
 **/
public class TryDemo {

    public static void main(String[] args) {
        System.out.println("--i : " + pre());
        System.out.println("=======================");
        System.out.println("i-- : " + after());

    }

    public static int pre() {
        int i = 10;
        try {
            System.out.println("i in try block is ： " + i);
            i = i / 0;
            return --i;
        } catch (Exception e) {
            System.out.println("i in catch - form try block is ： " + i);
            --i; //执行
            System.out.println("i in catch block is ： " + i);
            return --i;//执行
        } finally {
            System.out.println("i in finally - from try or catch block is--" + i);
            --i;//执行
            System.out.println("i in finally block is--" + i);
            return --i;//执行
        }
    }


    public static int after() {
        int i = 10;
        try {
            System.out.println("i in try block is ： " + i);
            i = i / 0;
            return i--;
        } catch (Exception e) {
            System.out.println("i in catch - form try block is ： " + i);
            i--;//执行
            System.out.println("i in catch block is ： " + i);
            return i--;//执行
        } finally {
            System.out.println("i in finally - from try or catch block is--" + i);
            i--;//执行
            System.out.println("i in finally block is--" + i);
            return i--; //注意:  未执行 !!!!!!!!!!
        }
    }
}
