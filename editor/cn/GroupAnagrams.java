//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//
// 
//
// 示例 1: 
//
// 
// 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"] 
// 
//
// 输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 解释： 
//
// 
// 在 strs 中没有字符串可以通过重新排列来形成 "bat"。 
// 字符串 "nat" 和 "tan" 是字母异位词，因为它们可以重新排列以形成彼此。 
// 字符串 "ate" ，"eat" 和 "tea" 是字母异位词，因为它们可以重新排列以形成彼此。 
// 
//
// 示例 2: 
//
// 
// 输入: strs = [""] 
// 
//
// 输出: [[""]] 
//
// 示例 3: 
//
// 
// 输入: strs = ["a"] 
// 
//
// 输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 2728 👎 0


package editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        System.out.println(solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(solution.groupAnagrams(new String[]{"ddddddddddg", "dgggggggggg"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null || strs.length == 0) {
                return Collections.emptyList();
            }
            if (strs.length == 1) {
                return Collections.singletonList(Collections.singletonList(strs[0]));
            }
            Map<String, List<String>> ansMap = new HashMap<>();
            for (String str : strs) {
                //str -> map idx
                char[] charArray = str.toCharArray();
                int[] idxArr = new int[26];
                for (char c : charArray) {
                    idxArr[c - 'a']++;
                }
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < idxArr.length; j++) {
                    if (idxArr[j] == 0) {
                        continue;
                    }
                    sb.append((char) ('a' + j));
                    sb.append(idxArr[j]);
                }
                String idx = sb.toString();
                List<String> strings = ansMap.computeIfAbsent(idx, k -> new ArrayList<>());
                strings.add(str);
            }
            return new ArrayList<>(ansMap.values());
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}