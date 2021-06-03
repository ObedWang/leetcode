//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// 
// '.' 匹配任意单个字符 
// '*' 匹配零个或多个前面的那一个元素 
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
// 
//
// 示例 1： 
//
// 
//输入：s = "aa" p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 
//输入：s = "aa" p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3： 
//
// 
//输入：s = "ab" p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4： 
//
// 
//输入：s = "aab" p = "c*a*b"
//输出：true
//解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5： 
//
// 
//输入：s = "mississippi" p = "mis*is*p*."
//输出：false 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 20 
// 0 <= p.length <= 30 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 保证每次出现字符 * 时，前面都匹配到有效的字符 
// 
// Related Topics 字符串 动态规划 回溯算法 
// 👍 2152 👎 0

package editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author web
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new RegularExpressionMatching().new Solution();
        System.out.println(solution.isMatch("aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s"));
        System.out.println(solution.isMatch("", ""));
        System.out.println(!solution.isMatch("", "a"));
        System.out.println(!solution.isMatch("a", ""));
        System.out.println(solution.isMatch("", ".*"));
        System.out.println(solution.isMatch("", "a*"));
        System.out.println(!solution.isMatch("", "."));
        System.out.println(!solution.isMatch("aa", "a"));
        System.out.println(solution.isMatch("aa", "a*"));
        System.out.println(solution.isMatch("ab", ".*"));
        System.out.println(solution.isMatch("aab", "c*a*b"));
        System.out.println(!solution.isMatch("mississippi", "mis*is*p*."));
        System.out.println(solution.isMatch("mississippi", "mis*is*ip*."));
        System.out.println(solution.isMatch("a", "ab*"));



    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Character> characterList = new ArrayList<>();
        List<Boolean> isAnyList = new ArrayList<>();

        public boolean isMatch(String s, String p) {
            //模式串为空
            if (p.length() == 0) return s.length() == 0;
            dealP(p);
            //匹配串为空
            if (s.length() == 0) {
                for (boolean b : isAnyList) {
                    if (!b) return false;
                }
                return true;
            }
            //s,p 均不为空
            boolean[][] dp = new boolean[characterList.size()][s.length() + 1];
            char[] chars = s.toCharArray();

            //处理第一行
            Character startC = characterList.get(0);
            Boolean isAny = isAnyList.get(0);
            if (isAny) {
                dp[0][0] = true;
                for (int i = 1; i < dp[0].length; i++) {
                    if (startC == '.' || startC == chars[i - 1]) dp[0][i] = true;
                    else break;
                }
            } else {
                if (startC == '.' || startC == chars[0]) dp[0][1] = true;
                else return false;
            }

            //处理后续几行
            for (int i = 1; i < dp.length; i++) {
                Character c = characterList.get(i);
                Boolean any = isAnyList.get(i);
                //any 匹配0特殊处理
                if (any) {
                    for (int j = 0; j < dp[0].length; j++) {
                        if (dp[i - 1][j]) {
                            dp[i][j] = true;
                        }
                    }
                }
                for (int j = 1; j < dp[0].length; j++) {
                    if (dp[i - 1][j - 1]) {
                        if (any) {
                            for (int k = j; k < dp[0].length; k++) {
                                if (c == '.' || c == chars[k - 1]) dp[i][k] = true;
                                else break;
                            }
                        } else {
                            if (c == chars[j - 1] || c == '.') {
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
            return dp[characterList.size() - 1][s.length()];
        }

        private void dealP(String p) {
            characterList.clear();
            isAnyList.clear();
            char[] chars = p.toCharArray();
            int index = 0;
            while (index < chars.length) {
                characterList.add(chars[index]);
                if (index < chars.length - 1 && chars[index + 1] == '*') {
                    isAnyList.add(true);
                    index += 2;
                } else {
                    isAnyList.add(false);
                    index++;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}