//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
// 
// 
// Related Topics 数组 
// 👍 542 👎 0

package editor.cn;

/**
 * @author web
 */
public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        Solution solution = new ShortestUnsortedContinuousSubarray().new Solution();
        System.out.println(solution.findUnsortedSubarray(new int[]{1,2,3,4})==0);
        System.out.println(solution.findUnsortedSubarray(new int[]{1})==0);
        System.out.println(solution.findUnsortedSubarray(new int[]{1,2,3,4,5,6,3})==4);
        System.out.println(solution.findUnsortedSubarray(new int[]{4,3,2,1})==4);
        System.out.println(solution.findUnsortedSubarray(new int[]{1,2,3,4,3,2,1})==6);
        System.out.println(solution.findUnsortedSubarray(new int[]{4,3,2,1,2,3,4})==6);
        System.out.println(solution.findUnsortedSubarray(new int[]{2,1})==2);
        System.out.println(solution.findUnsortedSubarray(new int[]{1,3,5,4,2})==4);
        System.out.println(solution.findUnsortedSubarray(new int[]{2,6,4,8,10,9,15})==5);

    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int findUnsortedSubarray(int[] nums) {
        //[2,6,4,8,10,9,15] -> 5
        if(nums.length<=1) return 0;
        int leftIndex=nums.length,rightIndex=nums.length-1;
        boolean start = false;
        for(int i=1;i<nums.length;i++){
            if(!start&&nums[i]<nums[i-1]) {
                start = true;
                leftIndex = i;
            }
            if(start&&nums[i]<nums[leftIndex]){
                leftIndex = i;
            }
        }
        if(leftIndex==nums.length) return 0;
        start = false;
        for(int i=nums.length-2;i>=0;i--){
            if(!start&&nums[i]>nums[i+1]){
                start = true;
                rightIndex = i;
            }
            if(start&&nums[i]>nums[rightIndex]){
                rightIndex = i;
            }
        }
        int leftAns = 0,rightAns = nums.length-1;
        for(int i=0;i<leftIndex;i++){
            if(nums[i]>nums[leftIndex]){
                leftAns = i;
                break;
            }
        }
        for(int i=nums.length-1;i>rightIndex;i--){
            if(nums[i]<nums[rightIndex]){
                rightAns = i;
                break;
            }
        }
        return rightAns-leftAns+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}