//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 437 👎 0

package editor.cn;

import java.util.*;

/**
 * @author web
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
        System.out.println(solution.zigzagLevelOrder(TreeNode.construct(new Integer[]{3,9,20,null,null,15,7})));
        System.out.println(solution.zigzagLevelOrder(TreeNode.construct(new Integer[]{1})));
        System.out.println(solution.zigzagLevelOrder(TreeNode.construct(new Integer[]{1,2})));
        System.out.println(solution.zigzagLevelOrder(TreeNode.construct(new Integer[]{1,2,3,4,null,null,5})));

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if(root==null) return Collections.emptyList();
            Stack<TreeNode> queue = new Stack<>();
            Stack<TreeNode> stack = new Stack<>();
            queue.add(root);
            List<List<Integer>> ans = new ArrayList<>();
            while (!queue.isEmpty() || !stack.empty()) {
                List<Integer> list = new ArrayList<>();
                while (!queue.isEmpty()) {
                    TreeNode node = queue.pop();
                    list.add(node.val);
                    if (node.left != null) stack.add(node.left);
                    if (node.right != null) stack.add(node.right);
                }
                if (!list.isEmpty()) ans.add(list);
                list = new ArrayList<>();
                while (!stack.empty()) {
                    TreeNode node = stack.pop();
                    list.add(node.val);
                    if (node.right != null) queue.add(node.right);
                    if (node.left != null) queue.add(node.left);
                }
                if (!list.isEmpty()) ans.add(list);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}