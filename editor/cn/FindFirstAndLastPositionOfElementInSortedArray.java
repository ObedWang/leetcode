//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 1039 👎 0

package editor.cn;

import java.util.Arrays;

/**
 * @author web
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        System.out.println(Arrays.toString(solution.searchRange(new int[]{}, 1)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{1, 2, 3, 4, 4, 4, 4, 5}, 4)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{1, 2, 2, 4, 4, 4, 4, 5}, 3)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{1, 2}, 2)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{1, 2}, 1)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{1}, 1)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) return new int[]{-1, -1};
            int i = find(nums, 0, nums.length - 1, target);
            if (i == -1) return new int[]{-1, -1};
            int min = i, max = i;
            while (min > 0) {
                if (nums[min - 1] == target) min--;
                else break;
            }
            while (max < nums.length-1 && nums[max] == target) {
                if (nums[max + 1] == target) max++;
                else break;
            }
            return new int[]{min, max};

        }


        private int find(int[] nums, int start, int end, int target) {
            if (start > end) {
                return -1;
            }
            int temp = (start + end) / 2;
            if (nums[temp] > target) {
                return find(nums, start, temp - 1, target);
            } else if (nums[temp] < target) {
                return find(nums, temp + 1, end, target);
            } else {
                return temp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}