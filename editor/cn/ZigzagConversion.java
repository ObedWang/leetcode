//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//示例 2：
//
// 
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
// Related Topics 字符串 
// 👍 1112 👎 0

package editor.cn;

/**
 * @author think
 */
public class ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new ZigzagConversion().new Solution();
        System.out.println(solution.convert("PAYPALISHIRING",3).equals("PAHNAPLSIIGYIR"));
        System.out.println(solution.convert("PAYPALISHIRING",4).equals("PINALSIGYAHRPI"));
        System.out.println(solution.convert("PAYPALISHIRING",5).equals("PINALSIGYAHRPI"));
        System.out.println(solution.convert("PAYPALISHIRING",7).equals("PINALSIGYAHRPI"));
        System.out.println(solution.convert("AB",1).equals("AB"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            char[] chars = s.toCharArray();
            int numColumns = chars.length;
            char[][] table = new char[numRows][numColumns];
            int i = 0, j = 0, k = 0;
            while (k < chars.length) {
                if (i == 0) {
                    while (i < numRows && k < chars.length) {
                        table[i++][j] = chars[k++];
                    }
                } else if (i == numRows) {
                    i--;
                    while (i > 1 && k < chars.length) {
                        table[--i][++j] = chars[k++];
                    }
                    i=0;
                    j++;
                }
            }
            char[] ans = new char[chars.length];
            int index = 0;
            for (i = 0; i < numRows; i++) {
                for (j = 0; j < numColumns; j++) {
                    if(judge(table[i][j])) ans[index++] = table[i][j];
                }
            }
            return new String(ans);
        }

        private boolean judge(char c) {
            if (c >= 'a' && c <= 'z') return true;
            if (c >= 'A' && c <= 'Z') return true;
            if (c == '.' || c == ',') return true;
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}