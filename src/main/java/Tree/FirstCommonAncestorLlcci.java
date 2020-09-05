package Tree;

/**
 * @ClassName FirstCommonAncestorLlcci
 * @Description TODO
 * @Author Haining
 * @Date 2020/8/7 0:27
 * @Version 1.0
 */
/**
 * 设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。
 * 不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。
 *
 * 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-common-ancestor-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 面试题 04.08. 首个共同祖先
 *
 * 递归
 * 两种：第二种是简化的
 */
public class FirstCommonAncestorLlcci {

    //第一种是没有优化的，时间比较慢一点
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q){
        //如果为空则返回NULL
        if(root == null){
            return null;
        }
        //左子树如果包含p或q则返回该节点
        TreeNode leftNode = lowestCommonAncestor1(root.left, p, q);
        //右子树如果包含p或q则返回该节点
        TreeNode rightNode = lowestCommonAncestor1(root.right, p, q );
        //如果当前节点是p或q则返回该节点
        if (root == p || root == q){
            return root;
        }
        //如果左右两个都不为空，则说明p和q在root下，左子树一个右子树一个
        if (leftNode != null && rightNode != null){
            return root;
        }
        //如果左子树不为空，右子树为空，说明左子树包含两个节点
        else if (leftNode != null){
            return leftNode;
        }
        //如果右子树不为空，左子树为空，说明右子树包含两个节点
        else {
            return rightNode;
        }
    }


    //第二种是进行了优化的时间上更快
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor2(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor2(root.right, p ,q);
        if(leftNode == null){
            return rightNode;
        }
        if(rightNode == null){
            return leftNode;
        }
        return root;
    }


}
