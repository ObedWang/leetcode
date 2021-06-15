//给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 动态规划 
// 👍 1018 👎 0

package editor.cn;

import java.util.*;

/**
 * @author web
 */
public class WordBreak {
    public static void main(String[] args) {
        Solution solution = new WordBreak().new Solution();
        System.out.println(solution.wordBreak("leetcode",new ArrayList(Arrays.asList(new String[]{"leet","code"}))));
        System.out.println(solution.wordBreak("applepenapple",new ArrayList(Arrays.asList(new String[]{"apple", "pen"}))));
        System.out.println(!solution.wordBreak("catsandog",new ArrayList(Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"}))));

    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Set<Integer> set1 = new HashSet<>(),set2 = new HashSet<>();

        for(int i=0;i<s.length();i++){
            String str = s.substring(0,i+1);
            if(set.contains(str)) set1.add(i);
        }
        if(set1.contains(s.length()-1)) return true;
        while(!set1.isEmpty()){
            for (Integer i : set1) {
                for(int j = i+1;j<s.length();j++){
                    String str = s.substring(i+1,j+1);
                    if(set.contains(str)){
                        set2.add(j);
                    }
                }
            }
            set1.clear();
            if(set2.contains(s.length()-1)) return true;
            Set<Integer> temp = set1;
            set1 = set2;
            set2 = temp;
        }
        return false;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}