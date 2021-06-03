//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1814 👎 0

package editor.cn;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author web
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(4).size());
        System.out.println(solution.generateParenthesis(3));
        System.out.println(solution.generateParenthesis(2));
        System.out.println(solution.generateParenthesis(1));
        System.out.println(solution.generateParenthesis(0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //["(((())))","()((()))","((()))()","(()(()))","()()(())","()(())()","((())())","(())()()","((()()))","()(()())","(()())()","(()()())","()()()()"]
        //["((()))","(()())","(())()","()(())","()()()"]
        public List<String> generateParenthesis(int n) {
            list.clear();
            recursion(n,n,"");
            return list;
        }

        List<String> list = new ArrayList<>();
        private void recursion(int left,int right,String str){
            if(left==0&&right==0) list.add(str);
            if(left>0){
                recursion(left-1,right,str+"(");
            }
            if(right>left){
                recursion(left,right-1,str+")");
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}