//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 链表 双指针 分治 排序 归并排序 
// 👍 1194 👎 0

package editor.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author web
 */
public class SortList {
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null) return null;
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while(node!=null){
            list.add(node);
            node = node.next;
        }
        list.sort(Comparator.comparingInt(o -> o.val));
        node = list.get(0);
        ListNode result = node;
        for(int i=1;i<list.size();i++){
            node.next = list.get(i);
            node = node.next;
        }
        node.next = null;
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}