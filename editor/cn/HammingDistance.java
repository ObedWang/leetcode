//两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。 
//
// 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 1, y = 4
//输出：2
//解释：
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//上面的箭头指出了对应二进制位不同的位置。
// 
//
// 示例 2： 
//
// 
//输入：x = 3, y = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x, y <= 231 - 1 
// 
// Related Topics 位运算 
// 👍 487 👎 0

package editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author web
 */
public class HammingDistance {
    public static void main(String[] args) {
        Solution solution = new HammingDistance().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int hammingDistance(int x, int y) {
            List<Integer> xList = getBinary(x);
            List<Integer> yList = getBinary(y);
            int length = Math.max(xList.size(), yList.size());
            int ans = 0;
            for (int i = 0; i < length; i++) {
                int xNum = i >= xList.size() ? 0 : xList.get(i);
                int yNum = i >= yList.size() ? 0 : yList.get(i);
                if (xNum != yNum) ans++;
            }
            return ans;
        }

        public List<Integer> getBinary(int x) {
            List<Integer> list = new ArrayList<>();
            do {
                list.add(x % 2);
                x /= 2;
            } while (x > 0);
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}