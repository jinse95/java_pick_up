package javalang.动态代理;

/**
 * @author J
 * @time 2018/10/24 22:25
 * @description
 **/
public class EatStaticProxy implements Eat {

    private Eat eat;

    public EatStaticProxy(Eat eat) {
        this.eat = eat;
    }

    @Override
    public void eatFood(String food) {
        System.out.println("饭前吃点凉菜");
        eat.eatFood(food);
        System.out.println("饭后吃点水果");
    }
}
