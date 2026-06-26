//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,0,1,2]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 并查集 数组 哈希表 👍 2913 👎 0


package editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
        System.out.println(solution.longestConsecutive(new int[]{1, 0, 1, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            if(nums.length==0) return 0;
            Set<Integer> set = new HashSet<>(nums.length);
            for (int num : nums) {
                set.add(num);
            }
            int ans = 1;
            for (Integer i : set) {
                if (set.contains(i - 1)) {
                    continue;
                }
                //没有在前面的数字了
                int curAns = 1, curNum = i;
                while (set.contains(++curNum)) {
                    curAns++;
                }
                ans = Math.max(ans, curAns);
            }
            return ans;
        }


//        public int longestConsecutive(int[] nums) {
//            if (nums.length == 0) return 0;
//            if (nums.length == 1) return 1;
//            Arrays.sort(nums);
//            int ans = 1, cur = 1;
//            for (int i = 0; i < nums.length - 1; i++) {
//                if (nums[i] + 1 == nums[i + 1]) {
//                    cur++;
//                } else if (nums[i] == nums[i + 1]) {
//                    //当前值跟下一个值一样，跳过
//                    continue;
//                } else {
//
//                    //如果不连续了，那要比较，并清空了
//                    ans = Math.max(ans, cur);
//                    cur = 1;
//                }
//            }
//            ans = Math.max(ans, cur);
//            return ans;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}