package 值传递_引用传递;

/**
 * @author J
 * @time 2018/1/3 23:08
 * @description
 **/
public class ReferencePkValue2 {

    public static void main(String[] args) {
        ReferencePkValue2 t = new ReferencePkValue2();
        int a=99;
        t.test1(a);//这里传递的参数a就是按值传递
        System.out.println(a);

    }

    public void test1(int a){
        a=a++;
        System.out.println(a);
    }

}
