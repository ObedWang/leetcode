//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 1974 👎 0


package editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        System.out.println(solution.findAnagrams("abab", "ab"));
    }

    // . l
    //  . cbaebabacd . abc
    //    r
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            if (p.length() > s.length()) return Collections.emptyList();
            int left = 0, right = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < p.length(); i++) {
                char c = p.charAt(i);
                int cnt = map.getOrDefault(c, 0);
                map.put(c, cnt+1);
            }
            Map<Character, Integer> temp = new HashMap<>();
            List<Integer> ans = new ArrayList<>();
            for (; right < p.length(); right++) {
                char c = s.charAt(right);
                if (map.containsKey(c)) {
                    Integer cnt = temp.getOrDefault(c, 0);
                    temp.put(c, cnt + 1);
                }
            }
            if (isSame(map, temp)) ans.add(left);
            for (; right < s.length(); right++, left++) {

                char addChar = s.charAt(right);
                char removeChar = s.charAt(left);
                if (map.containsKey(addChar)) {
                    Integer cnt = temp.getOrDefault(addChar, 0);
                    temp.put(addChar, cnt + 1);
                }
                if (map.containsKey(removeChar)) {
                    Integer cnt = temp.getOrDefault(removeChar, 0);
                    temp.put(removeChar, cnt - 1);
                }
                if (isSame(map, temp)) ans.add(left+1);
            }
            return ans;
        }

        private boolean isSame(Map<Character, Integer> map, Map<Character, Integer> temp) {
            if (map.size() != temp.size()) return false;
            for (Map.Entry<Character, Integer> entry : temp.entrySet()) {
                Character key = entry.getKey();
                Integer value = entry.getValue();
                if (!Objects.equals(value, map.get(key))) return false;
            }
            return true;
        }

        public List<Integer> findAnagrams1(String s, String p) {
            if (s.length() < p.length()) return Collections.emptyList();
            List<Integer> ans = new ArrayList<>();
            char[] sChars = s.toCharArray();
            char[] pChars = p.toCharArray();
            int[] pArray = new int[26];
            Set<Character> set = new HashSet<>();
            for (char pChar : pChars) {
                pArray[pChar - 'a']++;
                set.add(pChar);
            }
            int right = 0;
            int[] copyArray = Arrays.copyOf(pArray, 26);
            for (int i = 0; i < sChars.length; ) {
                boolean otherChar = false;
                while (right < sChars.length && right - i < pChars.length) {
                    if (!set.contains(sChars[right])) {
                        i = right + 1;
                        right++;
                        copyArray = Arrays.copyOf(pArray, 26);
                        otherChar = true;
                        break;
                    }
                    int idx = sChars[right] - 'a';
                    if (copyArray[idx] > 0) {
                        copyArray[idx]--;
                        right++;
                    } else {
                        break;
                    }
                }
                if (otherChar) continue;
                ;
                if (right - i == pChars.length) {
                    ans.add(i);
                }
                copyArray[sChars[i] - 'a']++;
                i++;
            }
            return ans;


        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}