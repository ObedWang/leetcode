//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 759 👎 0

package editor.cn;

import java.util.*;

/**
 * @author web
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Key,List<String>> map = new HashMap<>();
        for(String str:strs){
            Key key = new Key();
            char[] chars = str.toCharArray();
            for(char c:chars){
                key.put(c);
            }
            List<String> strings = map.computeIfAbsent(key, k -> new ArrayList<>());
            strings.add(str);
        }
        return new ArrayList<>(map.values());
    }

    class Key{
        int[] chars = new int[26];
        void put(char c){
            chars[c-'a']++;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return Arrays.equals(chars, key.chars);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(chars);
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}