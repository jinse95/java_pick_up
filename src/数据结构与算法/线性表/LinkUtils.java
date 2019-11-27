package 数据结构与算法.线性表;

/**
 * @author J
 */
public class LinkUtils {

    public static void pringtAll(LinkNode node) {
        while (node != null) {
            System.out.print(node.getData() + " ==> ");
            node = node.getNext();
        }
        System.out.println("null");
        System.out.println("\n*******************************************************************************\n");
    }


    /**
     * 是否有环
     *
     * @param node
     * @return
     */
    public static boolean haveRing(LinkNode node) {
        if (node == null || node.getNext() == null) {
            return false;
        }

        LinkNode slow = node;
        LinkNode fast = node;
        while (fast != null) {
            fast = fast.getNext();
            //null表示结束
            if (fast == null) {
                return false;
            }

            fast = fast.getNext();
            slow = slow.getNext();
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        /**
         * 测试是否有环
         */
        LinkNode start = new LinkNode("aa","aa");
        LinkNode i1 = new LinkNode("bb","bb");
        start.setNext(i1);

        LinkNode i2= new LinkNode("cc","cc");
        i1.setNext(i2);

        LinkNode i3 = new LinkNode("dd","dd");
        i2.setNext(i3);
//        i3.setNext(start);

        System.out.println(haveRing(start));
    }
}
