package 多线程.线程池;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * created on 2018/11/26.
 *
 * @author J
 **/
public class ClickTask implements Runnable {

    private static AtomicInteger counter = new AtomicInteger(0);

    private String se;

    public ClickTask(String se) {
        this.se = se;
    }

    @Override
    public void run() {
        if ("1".equals(se)) {
            this.clickSe1();
        } else if ("2".equals(se)) {
            this.clickSe2();
        } else {
            clickSe();
        }
        this.sleepS(2);
        counter.getAndIncrement();
    }

    public void clickSe1() {
        WebDriver driver;

        synchronized (ClickTask.class) {
            System.out.println("se1  step1");
            driver = getDriver("www.baidu.com");
        }

        this.sleepS(3);

        synchronized (ClickTask.class) {
            System.out.println("se1  step2");
        }

        driver.quit();
    }

    public void clickSe2() {
        WebDriver driver;
        synchronized (ClickTask.class) {
            System.out.println("se2  step1");
            driver = getDriver("www.so.com");
        }

        this.sleepS(3);

        synchronized (ClickTask.class) {
            System.out.println("se2  step2");
        }
    }


    public void clickSe() {
        synchronized (ClickTask.class) {
            System.out.println("se" + se + "  step1");
        }

        this.sleepS(3);

        synchronized (ClickTask.class) {
            System.out.println("se" + se + "  step2");
        }
    }


    private void sleepS(int s) {
        try {
            Thread.sleep(s * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static int getCounter() {
        return counter.get();
    }


    public WebDriver getDriver(String url) {
        System.setProperty("webdriver.chrome.driver", "d:/chromedriver.exe");//chromedriver服务地址
        WebDriver driver = new ChromeDriver(); //新建一个WebDriver 的对象，但是new 的是FirefoxDriver的驱动
        driver.get("http://" + url);//打开指定的网站
        return driver;
    }
}
