//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 3509 👎 0


package editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        System.out.println(solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int ansLength = nums.length - k + 1;
            if (ansLength <= 0) {
                int ans = Integer.MIN_VALUE;
                for (int i = 0; i < nums.length; i++) {
                    ans = Math.max(ans, nums[i]);
                }
                return new int[]{ans};
            }
            int[] ans = new int[ansLength];
            PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0];
                }
            });
            for (int i = 0; i < k; i++) {
                queue.add(new int[]{nums[i], i});
            }
            for (int i = 0; i < nums.length - k + 1; i++) {
                int[] arr = queue.peek();
                while (arr[1] < i) {
                    queue.poll();
                    arr = queue.peek();
                }
                ans[i] = arr[0];
                //idx in window
                //idx not in window
                if(i==nums.length-k) break;
                queue.add(new int[]{nums[i + k], i + k});
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}