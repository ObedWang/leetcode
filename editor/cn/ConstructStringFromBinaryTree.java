//你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。 
//
// 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。 
//
// 示例 1: 
//
// 
//输入: 二叉树: [1,2,3,4]
//       1
//     /   \
//    2     3
//   /    
//  4     
//
//输出: "1(2(4))(3)"
//
//解释: 原本将是“1(2(4)())(3())”，
//在你省略所有不必要的空括号对之后，
//它将是“1(2(4))(3)”。
// 
//
// 示例 2: 
//
// 
//输入: 二叉树: [1,2,3,null,4]
//       1
//     /   \
//    2     3
//     \  
//      4 
//
//输出: "1(2()(4))(3)"
//
//解释: 和第一个示例相似，
//除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
// 
// Related Topics 树 字符串 
// 👍 187 👎 0

package editor.cn;

/**
 * @author web
 */
public class ConstructStringFromBinaryTree {
    public static void main(String[] args) {
        Solution solution = new ConstructStringFromBinaryTree().new Solution();
        System.out.println(solution.tree2str(TreeNode.construct(new Integer[]{1, 2, 3, 4})).equals("1(2(4))(3)"));
        System.out.println(solution.tree2str(TreeNode.construct(new Integer[]{1, 2, 3, null, 4})).equals("1(2()(4))(3)"));
        System.out.println(solution.tree2str(TreeNode.construct(new Integer[]{})).equals(""));
        System.out.println(solution.tree2str(TreeNode.construct(new Integer[]{1})).equals("1"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public String tree2str(TreeNode t) {
            if(t==null) return "";
            String str = preOrder(t, t.right != null);
            return str.substring(1, str.length() - 1);
        }

        private String preOrder(TreeNode node, boolean add) {
            if (node == null) {
                if (add) return "()";
                else return "";
            }
            return "(" + node.val + preOrder(node.left, node.right != null) + preOrder(node.right, false) + ")";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}