package 设计模式.观察者;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察
 *
 * @author J
 * @since
 */
public class Observable {

    public void changed(){
        System.out.println("我是被观察者，我已经发生变化了");
        notifyObservers();
    }

    /**
     * 通知观察者
     */
    public void notifyObservers(){
        List<Observer> observers = listObserver();
        //for 循环只是一个例子
        for (Observer observer : observers) {
            observer.showInfo(this);
        }
    }

    private List<Observer> listObserver(){
        //从数据库中获取观察者列表
        return new ArrayList<>();
    }
}
