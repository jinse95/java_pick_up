import lombok.*;

import java.io.Serializable;

/**
 * @author J
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TestPOJO implements Serializable {

    private static final long serialVersionUID = -8209111328540706209L;
    private Integer age;
    private String name;

    private Boolean isMan = true;
}
