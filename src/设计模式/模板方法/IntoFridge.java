package 设计模式.模板方法;

/**
 * created on 2018/11/26
 *
 * @author J
 **/
public abstract class IntoFridge implements UseFridge {

    @Override
    public void putThing(String thing) {
        System.out.println("打开冰箱门");
        howToPut(thing);
        System.out.println("关上冰箱门");
    }

    protected abstract void howToPut(String thing);
}
