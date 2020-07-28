package javalang.继承.子类泛型;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author J
 */
@Data
@Accessors(chain = true)
public class MySon extends MyParent {
    private String sonAttr;

    public static void main(String[] args) {

        MySon son = new MySon().setSonAttr("isSonAttr");
        son.setAge(11).setName("son111");
        List<MySon> sons = Lists.newArrayList(
                son
        );

        List<MyParent> parents = (List) sons;
        for (MyParent mySon : parents) {
            System.out.println(mySon.getName());
        }
    }
}
