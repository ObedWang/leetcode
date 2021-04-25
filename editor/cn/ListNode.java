package editor.cn;

/**
 * @author : wangebie
 * @date : 2021/4/25 9:40
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode builder(int[] array) {
        if (array == null) return null;
        ListNode head = new ListNode(), node = head;
        for (int val : array) {
            node.next = new ListNode(val);
            node = node.next;
        }
        return head.next;
    }


    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(builder(new int[]{}));
        System.out.println(builder(new int[]{1}));
        System.out.println(builder(new int[]{1, 2}));
        System.out.println(builder(new int[]{1, 2, 3}));

    }
}
