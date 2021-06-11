//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 排序 数组 
// 👍 967 👎 0

package editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author web
 */
public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        int[][] arr = new int[][]{
                {1, 4}, {1, 3}, {2, 6}
        };
        System.out.println(Arrays.deepToString(solution.merge(arr)));
        arr = new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };
        System.out.println(Arrays.deepToString(solution.merge(arr)));
        arr = new int[][]{
                {1, 3}
        };
        System.out.println(Arrays.deepToString(solution.merge(arr)));
        arr = new int[][]{
                {1, 1},{3,3},{4,10}
        };
        System.out.println(Arrays.deepToString(solution.merge(arr)));
        arr = new int[][]{
                {1, 4},{2,3}
        };
        System.out.println(Arrays.deepToString(solution.merge(arr)));
    }

        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if(o1[0]==o2[0]){
                return o1[1]-o2[1];
            }else return o1[0]-o2[0];
        });
        List<int[]> list = new ArrayList<>();
        int index = 0;
        while(index< intervals.length){
            int[] subArr= new int[2];
            subArr[0] = intervals[index][0];
            subArr[1] = intervals[index][1];
            int end = index+1;
            while(end< intervals.length){
                if(intervals[end][0]>subArr[1]){
                    break;
                }
                subArr[1] = Math.max(intervals[end][1],subArr[1]);
                end++;
            }
            list.add(subArr);
            index = end;
        }
        return list.toArray(new int[][]{});
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}