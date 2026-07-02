//给定两个字符串 s 和 t，长度分别是 m 和 n，返回 s 中的 最短窗口 子串，使得该子串包含 t 中的每一个字符（包括重复字符）。如果没有这样的子串，
//返回空字符串 ""。 
//
// 测试用例保证答案唯一。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//O(m + n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 3634 👎 0


package editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC","ABC"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            char[] tChars = t.toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < tChars.length; i++) {
                Integer cnt = map.getOrDefault(tChars[i], 0);
                map.put(tChars[i], cnt + 1);
            }
            int i = 0, j = 0;
            char[] sc = s.toCharArray();
            int[] ans = new int[]{-1, -1};
            while (j < sc.length) {
                if (map.containsKey(sc[j])) {
                    int cnt = map.get(sc[j]) - 1;
                    map.put(sc[j], cnt);
                    if (cnt <= 0 && judgeMap(map)) {
                        ans[0] = 0;
                        ans[1] = j;
                        break;
                    }
                }
                j++;
            }
            if (ans[0] == -1) return "";
            while (j < sc.length) {

                while(i<j) {
                    if (!map.containsKey(sc[i])) {
                        i++;
                    } else {
                        Integer cnt = map.get(sc[i]);
                        if (cnt < 0) {
                            map.put(sc[i], cnt + 1);
                            i++;
                        }else break;
                    }
                }


                if (j - i <= ans[1] - ans[0]) {
                    ans[1] = j;
                    ans[0] = i;
                }

                j++;
                if(j>=sc.length) break;
                if (map.containsKey(sc[j])) {
                    map.put(sc[j], map.get(sc[j]) - 1);
                }

            }
            return s.substring(ans[0],ans[1]+1);
        }

        private boolean judgeMap(Map<Character, Integer> map) {
            return map.values().stream().noneMatch(x -> x > 0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}