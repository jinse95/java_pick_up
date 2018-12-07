package 设计模式.代理与责任链;

/**
 * created on 2018/12/7.
 *
 * @author J
 **/
public class OperateImpl implements Operate {

    @Override
    public void doInsert() {
        System.out.println("增操作");
    }

    @Override
    public void doDelete() {
        System.out.println("删操作");
    }

    @Override
    public void doUpdate() {
        System.out.println("改操作");
    }

    @Override
    public void doSelect() {
        System.out.println("查操作");
    }
}
