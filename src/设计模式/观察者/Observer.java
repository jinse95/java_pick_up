package 设计模式.观察者;

/**
 * 观察者
 *
 * @author J
 * @since
 */
public interface Observer {

    /**
     * 观察到变化展示信息
     * @param observable
     */
    void showInfo(Observable observable);
}
