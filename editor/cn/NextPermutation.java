//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 
// 👍 1149 👎 0

package editor.cn;


import java.util.Arrays;

/**
 * @author web
 */
public class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
        int[] nums = new int[]{1};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length<=1) return;
        int index=nums.length-1;
        for(;index>=0;index--){
            if(judge(nums,index)) break;
        }
        if(index==-1) {
            Arrays.sort(nums);
            return;
        }
        int largeIndex = findLargeIndex(nums, index);
        int temp = nums[index];
        nums[index] = nums[largeIndex];
        nums[largeIndex] = temp;
        Arrays.sort(nums,index+1,nums.length);
    }

    private boolean judge(int[] nums ,int k){
        for(int i=k+1;i<nums.length;i++){
            if(nums[i]>nums[k]) return true;
        }
        return false;
    }

    private int findLargeIndex(int[] nums,int k){
        int result = Integer.MAX_VALUE;
        int index = k;
        for(int i=k+1;i<nums.length;i++){
            if(nums[i]>nums[k]&&nums[i]<result) {
                result = nums[i];
                index = i;
            }
        }
        return index;
    }



}
//leetcode submit region end(Prohibit modification and deletion)

}