//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 1074 👎 0

package editor.cn;

import java.util.Arrays;

/**
 * @author web
 */
public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        int[] arr =new int[]{0};
        solution.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            public void moveZeroes(int[] nums) {
                int n = nums.length, left = 0, right = 0;
                while (right < n) {
                    if (nums[right] != 0) {
                        swap(nums, left, right);
                        left++;
                    }
                    right++;
                }
            }

            public void swap(int[] nums, int left, int right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
}
//leetcode submit region end(Prohibit modification and deletion)

}