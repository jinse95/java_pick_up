package 多线程.例子.银行窗口;

/**
 * @Description 客户队列  记录头尾引用的双向链表
 * @Author J
 * @Date 2018/6/19 15:33
 **/
public class ConsumerQueue {

    Node head;
    Node tail;

    int vipCount = 0;

    int size = 0;

    public ConsumerQueue() {
        this.head = this.tail = null;
    }

    public boolean isEmpty() {
        return this.head == null && this.tail == null;
    }

    /**
     * 排队
     *
     * @param consumer
     */
    public synchronized void inQueue(Consumer consumer) {
        Node node = new Node(consumer);
        if (this.isEmpty()) {
            this.head = this.tail = node;
            this.head.pre = null;
        } else {
            //尾巴的next 引用新节点
            this.tail.next = node;
            //新节点的per 引用老尾巴
            node.pre = this.tail;
            //尾巴指向当前节点
            this.tail = node;
        }

        if (consumer.isVip) {
            this.vipCount++;
        }

        this.size++;
        this.tail.next = null;
    }

    /**
     * 出队列 先进先出
     * vip客户优先出队列
     *
     * @return 出队的节点
     */
    public synchronized Consumer outQueue() {
        //若队列为空
        if (this.isEmpty()) {
            return null;
        }
        Consumer outConsumer = null;
        if (this.vipCount > 0) {
            //vip优先出队列
            outConsumer = this.outVip();
            if (outConsumer != null) {
                return outConsumer;
            }
        }

        outConsumer = this.head.consumer;
        //最后一个节点
        if (this.head.next == null) {
            this.head = this.tail = null;
        } else {
            //新头节点
            Node newHead = this.head.next;
            newHead.pre = null;
            //引用新的头节点
            this.head = newHead;
        }
        this.printQueue(outConsumer);

        return outConsumer;
    }

    /**
     * vip优先出队列
     */
    public synchronized Consumer outVip() {

        Node node = this.head;
        while (node != null) {
            if (node.consumer.isVip) {

                Node preVip = node.pre;
                Node nextVip = node.next;
                if (preVip != null) {
                    preVip.next = nextVip;
                } else {
                    //当前头节点出队  更新头节点
                    this.head = nextVip;
                }

                if (nextVip != null) {
                    nextVip.pre = preVip;
                } else {
                    //当前尾节点出队  更新尾节点
                    this.tail = preVip;
                }

                this.vipCount--;

                this.printQueue(node.consumer);
                return node.consumer;
            }

            node = node.next;
        }

        return null;
    }

    public synchronized void printQueue(Consumer consumer) {
        System.out.println(Thread.currentThread().getName() + "---" + consumer + "   出队了-------");
        System.out.print(Thread.currentThread().getName() + "---" + "还在排队的有:  ");
        Node node = this.head;
        while (node != null) {
            System.out.printf(node.consumer.toString());
            node = node.next;
        }
        System.out.println();
        System.out.println(Thread.currentThread().getName() + "---" + "打印剩余客户完成------");
    }

    class Node {
        Consumer consumer;
        Node pre;
        Node next;

        public Node(Consumer consumer) {
            this.consumer = consumer;
        }
    }
}
