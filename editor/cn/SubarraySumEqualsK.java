//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
//
// 子数组是数组中元素的连续非空序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 3186 👎 0


package editor.cn;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK().new Solution();
        System.out.println(solution.subarraySum(new int[]{1,1,1}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int pre = 0;
            int ans = 0;
            Map<Integer,Integer> mp = new HashMap<>();
            for(int i=0;i<nums.length;i++){
                if(i==0) pre = nums[i];
                else pre = pre+nums[i];



                if(mp.get(pre-k)!=null) ans+=mp.get(pre-k);
                if(pre==k) ans++;


                int cnt = mp.getOrDefault(pre, 0);
                mp.put(pre,cnt+1);

            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}