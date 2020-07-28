package javalang.继承.子类泛型;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author J
 */
@Data
@Accessors(chain = true)
public class MyParent {
    protected String name;
    protected Integer age;
}
