package 小坑;

/**
 * @Description 自动拆箱小坑
 * 三元运算符的自动拆箱问题
 * @author J
 * @Date 2018/7/11 11:24
 **/
public class AutoUnboxing {

    public static void main(String[] args) {
        //随便定义的对象,有length 和 width两个属性
        Box box = new Box();

        //正常运行
        if (box == null) {
            System.out.println(0);
        } else {
            System.out.println(box.getLength());
        }

        //不会触发自动拆箱,因此也是正常运行
        //对应的字节码: System.out.println(box == null?Integer.valueOf(0):box.getLength());
        System.out.println(box == null ? Integer.valueOf(0) : box.getLength());

        // 0 是一个基本数据类型(int)  会触发自动拆箱 调用Integer.intValue()  抛出空指针异常
        // 可以查看 AutoUnboxing.class 的字节码文件
        // 对应的字节码: System.out.println(box == null?0:box.getLength().intValue());
        System.out.println(box == null ? 0 : box.getLength());
    }


}

class Box {

    public Box() {
    }

    private Integer length;
    private Integer width;


    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }
}