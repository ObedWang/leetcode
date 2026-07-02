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

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1,-1}, 1)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //单调队列
        public int[] maxSlidingWindow(int[] nums, int k) {
            ArrayDeque<int[]> deque = new ArrayDeque<>();
            int ansLength = nums.length - k + 1;

            for (int i = 0; i < k; i++) {

                int[] last = deque.peekLast();
                while (last != null && last[0] < nums[i]) {
                    deque.pollLast();
                    last = deque.peekLast();
                }
                deque.add(new int[]{nums[i], i});
            }
            int[] ans = new int[ansLength];
            ans[0] = deque.peek()[0];
            for (int i = 1; i < ans.length; i++) {
                int idx = i + k - 1;

                int[] first = deque.peek();
                while (first!=null&&first[1] < i) {
                    deque.poll();
                    first = deque.peek();
                }
                int[] last = deque.peekLast();
                while (last != null && last[0] < nums[idx]) {
                    deque.pollLast();
                    last = deque.peekLast();
                }
                deque.add(new int[]{nums[idx], idx});
                ans[i] = deque.peek()[0];
            }
            return ans;
        }


        //优先队列
//        public int[] maxSlidingWindow(int[] nums, int k) {
//            int ansLength = nums.length-k+1;
//            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
//                @Override
//                public int compare(int[] o1, int[] o2) {
//                    return o1[0]==o2[0]?o2[1]-o1[1]:o2[0]-o1[0];
//                }
//            });
//
//            for(int i=0;i<k;i++){
//                pq.add(new int[]{nums[i],i});
//            }
//            int[] ans = new int[ansLength];
//            ans[0] = pq.peek()[0];
//            for(int i=1;i<ansLength;i++){
//                pq.add(new int[]{nums[i+k-1],i+k-1});
//                int[] peek = pq.peek();
//                while(peek[1]<i) {
//                    pq.poll();
//                    peek = pq.peek();
//                }
//                ans[i] = peek[0];
//            }
//            return ans;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}