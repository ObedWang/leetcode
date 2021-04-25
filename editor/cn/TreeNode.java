package editor.cn;

import java.util.*;

/**
 * @author : wangebie
 * @date : 2021/4/21 14:03
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode() {
    }

    @Override
    public String toString() {
        return "{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static TreeNode construct(Integer[] array) {
        if (array == null || array.length == 0) return null;
        return construct(array, 0);
    }

    private static TreeNode construct(Integer[] array, int index) {
        if (array[index] == null) return null;
        TreeNode node = new TreeNode(array[index]);
        int left = (index + 1) * 2 - 1, right = (index + 1) * 2;
        if (left < array.length) node.left = construct(array, left);
        if (right < array.length) node.right = construct(array, right);
        return node;
    }

    public static Integer[] plant(TreeNode node) {
        int level = countLevel(node);
        int count = 0;
        for (int i = 0; i < level; i++) {
            count += Math.pow(2, i);
        }
        Integer[] ans = new Integer[count];
        preOrder(ans, 0, node);
        return ans;
    }

    private static void preOrder(Integer[] list, int index, TreeNode node) {
        if (node == null) return;
        list[index] = node.val;
        preOrder(list, (index + 1) * 2 - 1, node.left);
        preOrder(list, (index + 1) * 2, node.right);
    }

    private static int countNum(TreeNode node) {
        if (node == null) return 0;
        return 1 + countNum(node.left) + countNum(node.right);
    }

    private static int countLevel(TreeNode node) {
        if (node == null) return 0;
        return Math.max(countLevel(node.left), countLevel(node.right)) + 1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plant(construct(new Integer[]{}))));
        System.out.println(Arrays.toString(plant(construct(new Integer[]{1}))));
        System.out.println(Arrays.toString(plant(construct(new Integer[]{1, 2}))));
        System.out.println(Arrays.toString(plant(construct(new Integer[]{1, 2, 3}))));
        System.out.println(Arrays.toString(plant(construct(new Integer[]{1, 2, null, null, 3}))));
    }
}
