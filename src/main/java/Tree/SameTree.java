package Tree;

/**
 * @ClassName SameTree
 * @Description TODO
 * @Author Haining
 * @Date 2020/8/7 0:45
 * @Version 1.0
 */

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 100. 相同的树
 *
 * 解法1：递归
 * 解法二：深度优先
 * 解法三：广度优先
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        else if (p == null || q == null){
            return false;
        }
        else if (p.val != q.val){
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
