//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SE
//E"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯算法 
// 👍 927 👎 0

package editor.cn;
/**
 * @author Obed
 */
public class WordSearch {
    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
        char[][] board = new char[][]{
                "ABCD".toCharArray(),
                "SFCS".toCharArray(),
                "ADEE".toCharArray()
        };
        System.out.println(solution.exist(board,"ABCCED"));
        System.out.println(solution.exist(board,"SEE"));
        System.out.println(solution.exist(board,"ABCB"));
        char[][] board1 = new char[][]{{'a'}};
        System.out.println(solution.exist(board1,"a"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        ans = false;
        this.board = board;
        this.word = word.toCharArray();
        boolean[][] map = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                exist(map,i,j,0);
                if(ans) return true;
            }
        }
        return false;
    }



    char[][] board ;
    char[] word;
    boolean ans;
    private void exist(boolean[][] map,int i,int j,int index){
        if(ans) return;
        if(map[i][j]) return;
        if(word[index]!=board[i][j]) return;
        map[i][j] = true;
        index +=1;
        if(index==word.length){
            ans = true;
            return;
        }
        if(i+1<map.length) exist(map,i+1,j,index);
        if(i-1>=0) exist(map,i-1,j,index);
        if(j+1<map[0].length) exist(map,i,j+1,index);
        if(j-1>=0) exist(map,i,j-1,index);
        map[i][j] = false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}