//路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不
//一定经过根节点。 
//
// 路径和 是路径中各节点值的总和。 
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
//
// 
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 104] 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 1075 👎 0

package editor.cn;

import sun.reflect.generics.tree.Tree;

/**
 * @author web
 */
public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeMaximumPathSum().new Solution();
//        System.out.println(solution.maxPathSum(TreeNode.construct(new Integer[]{1,2,3}))==6);
//        System.out.println(solution.maxPathSum(TreeNode.construct(new Integer[]{-10,9,20,null,null,15,7}))==42);
//        System.out.println(solution.maxPathSum(TreeNode.construct(new Integer[]{-3}))==-3);
//        System.out.println(solution.maxPathSum(TreeNode.construct(new Integer[]{2,-1}))==2);
//        System.out.println(solution.maxPathSum(TreeNode.construct(new Integer[]{1,-2,3}))==4);
        TreeNode root = TreeNode.construct(new Integer[]{9, 6, -3, null, null, -6, 2});
        TreeNode node = TreeNode.construct(new Integer[]{2, 2, -6, null, null, -6, -6});
        root.right.right = node;
        System.out.println(solution.maxPathSum(root));

    }
        //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        recursion(root);
        return ans;
    }

    int ans = Integer.MIN_VALUE;
    private int recursion(TreeNode node){
        if(node==null) return 0;
        int left = recursion(node.left);
        int right = recursion(node.right);
        int temp = Math.max(0,left)+Math.max(0,right)+node.val;
        ans = Math.max(temp,ans);
        return Math.max(Math.max(left,right)+node.val,0);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}