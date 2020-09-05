package Tree;

/**
 * @ClassName ValidateBinarySearchTree
 * @Description TODO
 * @Author Haining
 * @Date 2020/8/7 0:08
 * @Version 1.0
 */

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 *     节点的左子树只包含小于当前节点的数。
 *     节点的右子树只包含大于当前节点的数。
 *     所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 98. 验证二叉搜索树
 * 方法一：中序遍历，当前节点小于前一个节点就好了，二叉搜索树中序遍历一定是递增的。
 */
public class ValidateBinarySearchTree {

    //递归的写法
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }

        if (!isValidBST(root.left)){
            return false;
        }

        if (root.val <= pre){
            return false;
        }
        pre = root.val;

        return isValidBST(root.right);
    }
}
