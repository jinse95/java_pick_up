package 数据结构与算法.线性表;

import org.apache.commons.lang3.StringUtils;

/**
 * 哨兵节点 链表
 * @author J
 */
public class SentryLinkList {
    private LinkNode sentry;

    private int size = 0;

    public SentryLinkList() {
        //初始化哨兵节点
        this.sentry = new LinkNode();
    }

    public boolean delete(String key) {
        if (size == 0 || StringUtils.isBlank(key)) {
            return false;
        }
        LinkNode pre = this.sentry;
        LinkNode item = this.sentry.getNext();
        while (item != null) {
            if (item.getKey().equals(key)) {
                pre.setNext(item.getNext());
                size--;
                return true;
            }
            pre = item;
            item = item.getNext();
        }
        return false;
    }

    public void insert(String insertKey, Object o) {
        if (StringUtils.isBlank(insertKey)) {
            throw new IllegalArgumentException("key不能为空");
        }

        LinkNode item = this.sentry;
        while (item != null && item.getNext() != null) {
            item = item.getNext();
        }

        LinkNode insertNode = new LinkNode(insertKey, o);
        item.setNext(insertNode);
        size++;
    }

    public boolean insertPos(String posKey, String insertKey, Object o) {
        if (StringUtils.isBlank(posKey) || StringUtils.isBlank(insertKey)) {
            throw new IllegalArgumentException("key不能为空");
        }

        LinkNode getNode = this.find(posKey);
        if (getNode == null) {
            return false;
        }

        LinkNode insertNode = new LinkNode(insertKey, o);
        insertNode.setNext(getNode.getNext());
        getNode.setNext(insertNode);
        size++;
        return true;
    }


    public void reverse() {
        if (size < 2) {
            return;
        }

        LinkNode last;
        LinkNode newFirst;
        LinkNode newCurrent;

        LinkNode item = this.sentry;
        while (item != null && item.getNext() != null) {
            item = item.getNext();
        }
        last = item;
        newFirst = item;
        newCurrent = item;
        item = this.sentry.getNext();
        while (true) {
            while (item.getNext() != last) {
                item = item.getNext();
            }
            newCurrent.setNext(item);
            newCurrent = newCurrent.getNext();
            last = item;
            item = this.sentry.getNext();
            if (last == item) {
                break;
            }
        }

        last.setNext(null);
        this.sentry.setNext(newFirst);
    }



    private LinkNode find(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }

        LinkNode item = this.sentry.getNext();
        while (item != null) {
            if (item.getKey().equals(key)) {
                return item;
            }
            item = item.getNext();
        }
        return null;
    }


    public static void main(String[] args) {
        SentryLinkList list = new SentryLinkList();
        list.insert("aa", "aa");
        list.insert("bb", "bb");
        list.insert("cc", "cc");
        list.insert("dd", "dd");

        LinkUtils.pringtAll(list.sentry.getNext());
        list.reverse();
        LinkUtils.pringtAll(list.sentry.getNext());

    }
}
