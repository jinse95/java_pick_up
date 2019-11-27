package 数据结构与算法.线性表;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author J
 */
@Getter
@Setter
@NoArgsConstructor
public class LinkNode {

    public LinkNode(String key, Object data) {
        this.key = key;
        this.data = data;
        this.next = null;
    }

    private String key;

    private Object data;

    private LinkNode next;
}
