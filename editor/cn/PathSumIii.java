//给定一个二叉树，它的每个结点都存放着一个整数值。 
//
// 找出路径和等于给定数值的路径总数。 
//
// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。 
//
// 示例： 
//
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//返回 3。和等于 8 的路径有:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
// 
// Related Topics 树 
// 👍 889 👎 0

package editor.cn;

/**
 * @author web
 */
public class PathSumIii {
    public static void main(String[] args) {
        Solution solution = new PathSumIii().new Solution();
        TreeNode root = TreeNode.construct(new Integer[]{1, null, 2});
        TreeNode n1 = TreeNode.construct(new Integer[]{3,null,4});
        root.right.right = n1;
        n1.right.right = new TreeNode(5);
        System.out.println(solution.pathSum(root,3));
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
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        preOrder(root, targetSum);
        return count;
    }

    private void preOrder(TreeNode node,int target){
        if(node==null) return ;
        recursion(node,target,0);
        preOrder(node.left,target);
        preOrder(node.right,target);
    }

    int count = 0;
    private void recursion(TreeNode node,int target,int sum){
        sum+=node.val;
        if(sum==target) count++;
        if(node.left!=null){
            recursion(node.left,target,sum);
        }
        if(node.right!=null) {
            recursion(node.right,target,sum);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}