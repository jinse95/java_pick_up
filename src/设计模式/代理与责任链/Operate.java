package 设计模式.代理与责任链;

/**
 * 操作接口
 * created on 2018/12/5
 *
 * @author J
 **/
public interface Operate {
    void doInsert();

    void doDelete();

    void doUpdate();

    void doSelect();


}
