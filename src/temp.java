import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Description
 * @Author J
 * @Date 2018/8/30 10:25
 **/
public class temp {

    public static void main(String[] args) {

        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("-------");
        queue.poll();
        queue.poll();
        System.out.println("-------------");
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
