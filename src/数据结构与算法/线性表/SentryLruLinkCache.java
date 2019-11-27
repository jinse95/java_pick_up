package 数据结构与算法.线性表;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 增加哨兵的链表实现 LRU 缓存
 *
 * @author J
 */
public class SentryLruLinkCache {

    private LinkNode sentry;

    private int size = 0;

    private int capacity = 0;

    public SentryLruLinkCache(int capacity) {
        this.capacity = capacity;
        //初始化哨兵节点
        this.sentry = new LinkNode();
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
        LinkNode item = this.sentry.getNext();
        //记录非空节点的前驱节点
        LinkNode pre = sentry;
        LinkNode next;
        while (item != null) {
            //若存在
            if (key.equals(item.getKey())) {
                //前节点next 指向 当前节点next
                pre.setNext(item.getNext());
                //当前节点next 指向 哨兵next
                item.setNext(this.sentry.getNext());
                //哨兵next 指向当前节点
                this.sentry.setNext(item);
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
        node.setNext(this.sentry.getNext());
        this.sentry.setNext(node);

        if (size >= capacity) {
            if (pre != this.sentry) {
                pre.setNext(null);
            } else {
                //只有 capacity 为 1时
                node.setNext(null);
            }
        } else {
            this.size++;
        }

        return node;
    }

    public void printAll() {
        LinkNode item = this.sentry.getNext();
        System.out.println("size : " + this.size);
        LinkUtils.pringtAll(item);
    }


    public static void main(String[] args) {
        SentryLruLinkCache cache = new SentryLruLinkCache(2);
        cache.get("aa");
        cache.printAll();
        cache.get("aa");
        cache.printAll();
        cache.get("bb");
        cache.printAll();
        cache.get("cc");
        cache.printAll();
        cache.get("bb");
        cache.printAll();
        cache.get("aa");
        cache.printAll();
    }
}
