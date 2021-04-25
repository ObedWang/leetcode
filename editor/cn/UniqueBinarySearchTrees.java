//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划 
// 👍 1136 👎 0

package editor.cn;

/**
 * @author web
 */
public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees().new Solution();
        System.out.println(solution.numTrees(4));
        System.out.println(solution.numTrees(3));
        System.out.println(solution.numTrees(2));
        System.out.println(solution.numTrees(1));
        System.out.println(solution.numTrees(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTrees(int n) {
            int[] array = new int[n+1];
            array[0] = 1;
            array[1] = 1;
            for(int i=2;i<=n;i++){
                for(int j=1;j<=i;j++){
                    array[i]+=(array[j-1]*array[i-j]);
                }
            }
            return array[n];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}