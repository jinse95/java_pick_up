package 设计模式.模板方法;

/**
 * created on 2018/11/26
 *
 * @author J
 **/
public class PutElephant extends IntoFridge {
    @Override
    protected void howToPut(String thing) {
        System.out.println("首先把" + thing + "切小块");
        System.out.println("然后放进去");
    }

    public static void main(String[] args) {
        UseFridge useFridge = new PutElephant();
        useFridge.putThing("大象");
    }
}
