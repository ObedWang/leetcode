//给你一个整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 100 
// 
// Related Topics 深度优先搜索 动态规划 
// 👍 795 👎 0

package editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author web
 */
public class TargetSum {
    public static void main(String[] args) {
        Solution solution = new TargetSum().new Solution();
        System.out.println(solution.findTargetSumWays(new int[]{1},1)==1);
        System.out.println(solution.findTargetSumWays(new int[]{2,1},1)==1);
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        if(nums.length==1){
            if(nums[0]==target||-1*nums[0]==target) return 1;
            else return 0;
        }
        Map[] maps = new Map[nums.length];
        for(int i=0;i<maps.length;i++){
            maps[i] = new HashMap();
        }
        if(nums[0]==0){
            maps[0].put(0,2);
        }else{
            maps[0].put(nums[0],1);
            maps[0].put(-nums[0],1);
        }
        for(int i=1;i<maps.length;i++){
            int n = nums[i];
            Map<Integer,Integer> map = maps[i];
            for (Object obj : maps[i - 1].entrySet()) {
                Map.Entry<Integer,Integer> entry = (Map.Entry<Integer,Integer>) obj;
                Integer key = entry.getKey();
                Integer value = entry.getValue();
                map.merge(key + n, value, Integer::sum);
                map.merge(key - n, value, Integer::sum);
            }
        }
        Integer sum =(Integer) maps[maps.length - 1].get(target);
        if(sum==null) return 0;
        else return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}