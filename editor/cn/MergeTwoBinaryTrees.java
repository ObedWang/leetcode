//给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。 
//
// 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
//。 
//
// 示例 1: 
//
// 
//输入: 
//	Tree 1                     Tree 2                  
//          1                         2                             
//         / \                       / \                            
//        3   2                     1   3                        
//       /                           \   \                      
//      5                             4   7                  
//输出: 
//合并后的树:
//	     3
//	    / \
//	   4   5
//	  / \   \ 
//	 5   4   7
// 
//
// 注意: 合并必须从两个树的根节点开始。 
// Related Topics 树 
// 👍 697 👎 0

package editor.cn;

import java.util.Arrays;

/**
 * @author web
 */
public class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        Solution solution = new MergeTwoBinaryTrees().new Solution();
        TreeNode root1 = TreeNode.construct(new Integer[]{1, 3, 2, 5, null, null, null});
        TreeNode root2 = TreeNode.construct(new Integer[]{2, 1, 3, null, 4, null, 7});
        System.out.println(Arrays.toString(TreeNode.plant(solution.mergeTrees(root1,root2))));
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
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            return constructTree(root1, root2);
        }

        private TreeNode constructTree(TreeNode node1, TreeNode node2) {
            if (node1 == null && node2 == null) return null;
            if (node1 == null) {
                return node2;
            } else if (node2 == null) {
                return node1;
            } else {
                TreeNode treeNode = new TreeNode();
                treeNode.val = node1.val + node2.val;
                treeNode.left = constructTree(node1.left, node2.left);
                treeNode.right = constructTree(node1.right, node2.right);
                return treeNode;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}