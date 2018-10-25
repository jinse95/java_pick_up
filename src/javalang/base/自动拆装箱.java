package javalang.base;

/**
 * @Author J
 * @Date 2018/10/24 11:48
 * @Description
 **/
public class 自动拆装箱 {
    /**
     * 去查看字节码文件
     */
    public static void main(String[] args) {
        System.out.println("-------------");
        Integer i = 10;
        Integer j = i == 10 ? Integer.valueOf(20) : 10;
        Integer k = i == 10 ? Integer.valueOf(20) : Integer.valueOf(10);
        System.out.println(k);
        System.out.println("-----------" + i);
    }
}
