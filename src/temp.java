import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Description
 * @Author J
 * @Date 2018/8/30 10:25
 **/
public class temp {

    public static void printHeadAndTail(ConcurrentLinkedQueue<Integer> queue, Field[] fields, Field[] nodeFields) throws ClassNotFoundException, IllegalAccessException {
        for (Field item : fields) {
            if ("head".equals(item.getName()) || "tail".equals(item.getName())) {
                System.out.printf(item.getName());
                for (Field itemNode : nodeFields) {
                    String nodeItemName = itemNode.getName();
                    if ("item".equals(nodeItemName)) {
                        System.out.println(" item-----" + itemNode.get(item.get(queue)));
                    }
                }
            }
        }
        System.out.println("===========");
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InterruptedException {

        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
        Field[] fields = ConcurrentLinkedQueue.class.getDeclaredFields();
        for (Field item : fields) {
            item.setAccessible(true);
        }
        Field[] nodeFields = Class.forName("java.util.concurrent.ConcurrentLinkedQueue$Node").getDeclaredFields();
        for (Field item : nodeFields) {
            item.setAccessible(true);
        }

        for (int i = 1; i <= 4; i++) {
            if (queue.add(i)) {
                printHeadAndTail(queue, fields, nodeFields);
                Thread.sleep(1500);
            }
        }
    }
}

class User {
    private Integer id;
    private String name;
    private Integer age;

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }
}
