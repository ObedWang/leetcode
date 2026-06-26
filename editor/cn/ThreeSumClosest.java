  //给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个在 不同下标位置 的整数，使它们的和与 target 最
//接近。 
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2)。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
//解释：与 target 最接近的和是 0（0 + 0 + 0 = 0）。 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 双指针 排序 👍 1814 👎 0

  
  package editor.cn;

  import java.util.Arrays;

  public class ThreeSumClosest{
      public static void main(String[] args) {
           Solution solution = new ThreeSumClosest().new Solution();
          System.out.println(solution.threeSumClosest(new int[]{1,1,1,1},0));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length==3) return nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
            int otherSum = twoSumClosest(nums, i + 1, target - nums[i]);
            if(Math.abs(otherSum+nums[i]-target)<Math.abs(ans-target)){
                ans = otherSum+nums[i];
            }
        }
        return ans;
    }

    public int twoSumClosest(int[] nums,int startIdx,int target){
        int i = startIdx,j = nums.length-1;
        int closestAns = 100_000;
        while(i<j){
            if(Math.abs(nums[i]+nums[j]-target)<Math.abs(closestAns-target)){
                closestAns = nums[i]+nums[j];
            }
            if(nums[i]+nums[j]-target>0){
                j--;
            }else{
                i++;
            }
        }
        return closestAns;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }