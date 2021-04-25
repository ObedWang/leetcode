package editor.cn;

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

    public static void main(String[] args) {
        System.out.println(construct(new Integer[]{5,1,4,null,null,3,6}));
        System.out.println(construct(new Integer[]{1}));
        System.out.println(construct(new Integer[]{1,2}));
    }
}
