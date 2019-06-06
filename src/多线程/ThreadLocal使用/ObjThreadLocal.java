package 多线程.ThreadLocal使用;


import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.Data;
import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ObjThreadLocal {
    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(7, 7,
                60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(500),
                new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        int len = 60000;
        CountDownLatch countDownLatch = new CountDownLatch(len);
        for (int i = 0; i < len; i++) {
            executor.execute(() -> {
                User user = new User();
                user.setName(new String("名字"+ RandomUtils.nextInt()));
                ThreadLocalBox box = new ThreadLocalBox().setUser(user);
                countDownLatch.countDown();
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //若 不去 remove 可能导致内存泄漏
                box.removeThreadLocal();
            });
        }

        countDownLatch.await();
        System.gc();

        System.out.println("ok");
    }
}



class ThreadLocalBox{

    private ThreadLocal<User> user;

    public ThreadLocalBox() {
        this.user = new ThreadLocal<>();
    }

    public User getUser() {
        return user.get();
    }

    public ThreadLocalBox setUser(User user) {
        this.user.set(user);
        return this;
    }

    public void removeThreadLocal (){
        user.remove();
    }
}

@Data
class User{
    String name;
    int age = 10;
    long num = 6666666L;
    String phone ="13645784699";
}

