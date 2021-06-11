//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 回溯算法 
// 👍 1401 👎 0

package editor.cn;

import java.util.*;

/**
 * @author web
 */
public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        System.out.println(solution.permute(new int[]{1,2,3}));
        System.out.println(solution.permute(new int[]{1}));
        System.out.println(solution.permute(new int[]{}));
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if(nums==null||nums.length==0) return Collections.emptyList();
        this.nums = nums;
        recursion(new ArrayList<>(),new HashSet<>());
        return list;
    }

    List<List<Integer>> list = new ArrayList<>();
    int[] nums;
    private void recursion(List<Integer> subList,Set<Integer> set){
        if(subList.size()==nums.length){
            list.add(subList);
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])) continue;;
            List<Integer> list1 = new ArrayList<>(subList);
            list1.add(nums[i]);
            set.add(nums[i]);
            recursion(list1,set);
            set.remove(nums[i]);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}