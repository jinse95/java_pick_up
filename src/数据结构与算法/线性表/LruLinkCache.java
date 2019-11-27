package 数据结构与算法.线性表;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 链表实现 LRU 缓存
 *
 * @author J
 */
public class LruLinkCache {

    private LinkNode head;

    private int size = 0;

    private int capacity = 0;

    public LruLinkCache(int capacity) {
        this.capacity = capacity;
    }

    private Object get(String key) {
        LinkNode node = this.getNode(key);
        if (node == null) {
            return null;
        }
        return node.getData();
    }

    private LinkNode getNode(String key) {
        if (this.capacity < 1 || StringUtils.isBlank(key)) {
            return null;
        }
        LinkNode item = this.head;
        //记录非空节点的前驱节点
        LinkNode pre = null;
        LinkNode next;
        while (item != null) {
            //若存在
            if (key.equals(item.getKey())) {
                //非头节点
                if (pre != null) {
                    pre.setNext(item.getNext());
                    item.setNext(this.head);
                    this.head = item;
                }
                return item;
            }

            next = item.getNext();
            if (next != null) {
                pre = item;
            }
            item = next;
        }

        //模拟获取数据(例如实际业务中从数据库里查数据) 设为头节点
        LinkNode node = new LinkNode(key, key + "-" + RandomUtils.nextInt(100000, 999999));
        node.setNext(this.head);
        this.head = node;

        if (size >= capacity) {
            //表示该链表只有一个元素
            if (pre == null) {
                this.head.setNext(null);
            } else {
                pre.setNext(null);
            }
        } else {
            this.size++;
        }

        return this.head;
    }

    public void printAll() {
        LinkNode item = this.head;
        while (item != null) {
            System.out.print(item.getData() + " ==> ");
            item = item.getNext();
        }
        System.out.println("null");
        System.out.println("size: " + this.size);
        System.out.println("\n*************************************\n");
    }


    public static void main(String[] args) {
        LruLinkCache cache = new LruLinkCache(0);
        cache.get("aa");
        cache.printAll();
        cache.get("bb");
        cache.printAll();
        cache.get("cc");
        cache.printAll();
        cache.get("dd");
        cache.printAll();
        cache.get("bb");
        cache.printAll();
    }
}
