//给定在 xy 平面上的一组点，确定由这些点组成的矩形的最小面积，其中矩形的边平行于 x 轴和 y 轴。 
//
// 如果没有任何矩形，就返回 0。 
//
// 
//
// 示例 1： 
//
// 输入：[[1,1],[1,3],[3,1],[3,3],[2,2]]
//输出：4
// 
//
// 示例 2： 
//
// 输入：[[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= points.length <= 500 
// 0 <= points[i][0] <= 40000 
// 0 <= points[i][1] <= 40000 
// 所有的点都是不同的。 
// 
// Related Topics 哈希表 
// 👍 78 👎 0

package editor.cn;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author web
 */
public class MinimumAreaRectangle {
    public static void main(String[] args) {
        Solution solution = new MinimumAreaRectangle().new Solution();
        System.out.println(solution.minAreaRect(new int[][]{{3, 2}, {3, 1}, {4, 4}, {1, 1}, {4, 3}, {0, 3}, {0, 2}, {4, 0}}) == 0);
        System.out.println(solution.minAreaRect(new int[][]{{1, 1}, {1, 3}, {3, 1}, {3, 3}, {2, 2}}) == 4);
        System.out.println(solution.minAreaRect(new int[][]{{1, 1}, {1, 3}, {3, 1}, {3, 3}, {4, 1}, {4, 3}}) == 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minAreaRect(int[][] points) {
            Map<Integer, List<int[]>> x = new HashMap<>(), y = new HashMap<>();
            for (int[] point : points) {
                List<int[]> xList = x.computeIfAbsent(point[0], k -> new ArrayList<>());
                xList.add(point);
                List<int[]> yList = y.computeIfAbsent(point[1], k -> new ArrayList<>());
                yList.add(point);
            }
            x.values().forEach(i -> {
                if (i != null) {
                    i.sort(Comparator.comparingInt(o -> o[1]));
                }
            });
            y.values().forEach(j -> {
                if (j != null) {
                    j.sort(Comparator.comparingInt(o -> o[0]));
                }
            });
            int ans = Integer.MAX_VALUE;
            for (Integer i : x.keySet()) {
                List<int[]> intX = x.get(i);
                if (intX == null || intX.size() == 1) continue;
                for (int[] xGrid : intX) {
                    List<int[]> intY = y.get(xGrid[1]);
                    if (intY == null || intY.size() <= 1) continue;
                    int start = find(intY, xGrid[0], 0, intY.size() - 1, true) + 1;
                    for (; start < intY.size(); start++) {
                        int[] yGrid = intY.get(start);
                        List<int[]> intNextX = x.get(yGrid[0]);
                        if (intNextX == null || intNextX.size() <= 1) continue;
                        int start2 = find(intNextX, yGrid[1], 0, intNextX.size() - 1, false) + 1;
                        for (; start2 < intNextX.size(); start2++) {
                            int[] nextXGrid = intNextX.get(start2);
                            List<int[]> intNextY = y.get(nextXGrid[1]);
                            if (intNextY == null || intNextY.size() <= 1) continue;
                            for (int[] nextYGrid : intNextY) {
                                if (nextYGrid[0] == xGrid[0]) {
                                    ans = Math.min(ans, (nextYGrid[1] - xGrid[1]) * (yGrid[0] - xGrid[0]));
                                }
                            }
                        }
                    }


                }
            }
            if (ans == Integer.MAX_VALUE) ans = 0;
            return ans;
        }

        private int find(List<int[]> list, int aim, int left, int right, boolean isX) {
            if (left == right) return left;
            int position = (left + right) / 2;
            int temp;
            temp = isX ? list.get(position)[0] : list.get(position)[1];
            if (temp == aim) return position;
            else if (temp > aim) return find(list, aim, left, position - 1, isX);
            else return find(list, aim, position + 1, right, isX);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}