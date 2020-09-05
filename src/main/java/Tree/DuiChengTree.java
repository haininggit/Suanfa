package Tree;

/**
 * @ClassName DuiChengTree
 * @Description TODO
 * @Author Haining
 * @Date 2020/8/8 23:21
 * @Version 1.0
 */

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *
 * 剑指 Offer 28. 对称的二叉树
 *
 * 递归
 */
public class DuiChengTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }

        return left.val == right.val && helper(left.left, left.right) && helper(right.left, right.right);
    }
}
