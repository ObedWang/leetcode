//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
// Related Topics 数组 二分查找 分治算法 
// 👍 4145 👎 0

package editor.cn;

/**
 * @author web
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}) == 2);
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}) == 2.5);
        System.out.println(solution.findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}) == 0);
        System.out.println(solution.findMedianSortedArrays(new int[]{}, new int[]{2}) == 2);
        System.out.println(solution.findMedianSortedArrays(new int[]{1}, new int[]{}) == 1);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            return solution1(nums1, nums2);
        }


        public double solution2(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int m = nums2.length;
            int left = (n + m + 1) / 2;
            int right = (n + m + 2) / 2;
            //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
            return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
        }


        private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
            //分离复杂，该方法只求第k大的数，而不关心要求一个还是求两个，要不然偶合在一起，代码会变得复杂
            int len1 = end1 - start1 + 1;
            int len2 = end2 - start2 + 1;
            //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
            if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
            //如果一个数组空了，直接返回另外一个数组的第k大的数就好
            if (len1 == 0) return nums2[start2 + k - 1];

            if (k == 1) return Math.min(nums1[start1], nums2[start2]);

            int i = start1 + Math.min(len1, k / 2) - 1;
            int j = start2 + Math.min(len2, k / 2) - 1;

            if (nums1[i] > nums2[j]) {
                return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
            } else {
                return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
            }
        }


        public double solution1(int[] nums1, int[] nums2) {
            int total = nums1.length + nums2.length;
            int index = total / 2;
            boolean two = total % 2 == 0;
            double ans = 0;
            int i = 0;
            int j = 0;
            while (index >= 0) {
                int l = i == nums1.length ? Integer.MAX_VALUE : nums1[i];
                int r = j == nums2.length ? Integer.MAX_VALUE : nums2[j];
                int temp;
                if (l > r) {
                    temp = r;
                    j++;
                } else {
                    temp = l;
                    i++;
                }
                if (index == 1 && two) {
                    ans = temp;
                } else if (index == 0) {
                    ans += temp;
                    if (two) ans /= 2;
                }
                index--;
            }
            return ans;
        }

    }

//leetcode submit region end(Prohibit modification and deletion)
}

