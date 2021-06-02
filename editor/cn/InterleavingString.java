//给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。 
//
// 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串： 
//
// 
// s = s1 + s2 + ... + sn 
// t = t1 + t2 + ... + tm 
// |n - m| <= 1 
// 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ... 
// 
//
// 提示：a + b 意味着字符串 a 和 b 连接。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s1 = "", s2 = "", s3 = ""
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s1.length, s2.length <= 100 
// 0 <= s3.length <= 200 
// s1、s2、和 s3 都由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 458 👎 0

package editor.cn;

/**
 * @author web
 */
public class InterleavingString {
    public static void main(String[] args) {
        Solution solution = new InterleavingString().new Solution();
        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(!solution.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(solution.isInterleave("", "", ""));
        System.out.println(!solution.isInterleave("a", "b", "a"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[] chars1, chars2, chars3;

        public boolean isInterleave(String s1, String s2, String s3) {
            if (s3.length() != s1.length() + s2.length()) return false;
            if ("".equals(s1)) return s2.equals(s3);
            else if ("".equals(s2)) return s1.equals(s3);
            chars1 = s1.toCharArray();
            chars2 = s2.toCharArray();
            chars3 = s3.toCharArray();
            return dp();
        }

        private boolean internalInterleave(int l1, int l2) {
            int l3 = l1 + l2;
            if (l3 == chars3.length) return true;
            if (l1 < chars1.length && chars3[l3] == chars1[l1]) {
                boolean b = internalInterleave(l1 + 1, l2);
                if (b) return true;
            }
            if (l2 < chars2.length && chars3[l3] == chars2[l2]) {
                boolean b = internalInterleave(l1, l2 + 1);
                if (b) return true;
            }
            return false;
        }

        private boolean dp() {
            boolean[][] dp = new boolean[chars1.length + 1][chars2.length + 1];
            for (int i = 0; i < chars1.length; i++) {
                if (chars1[i] != chars3[i]) break;
                dp[i + 1][0] = true;
            }
            for (int i = 0; i < chars2.length; i++) {
                if (chars2[i] != chars3[i]) break;
                dp[0][i + 1] = true;
            }
            for (int i = 1; i < chars1.length + 1; i++) {
                for (int j = 1; j < chars2.length + 1; j++) {
                    if (dp[i - 1][j]) {
                        if (chars1[i - 1] == chars3[i + j - 1])
                            dp[i][j] = true;
                    }
                    if (dp[i][j - 1]) {
                        if (chars2[j - 1] == chars3[i + j - 1]) {
                            dp[i][j] = true;
                        }
                    }
                }
            }
            return dp[chars1.length][chars2.length];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}