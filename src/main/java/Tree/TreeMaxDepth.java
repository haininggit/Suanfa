package Tree;

/**
 * @ClassName TreeMaxDepth
 * @Description TODO
 * @Author Haining
 * @Date 2020/8/5 13:45
 * @Version 1.0
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（
 * 含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 剑指 Offer 55 - I. 二叉树的深度
 *
 * 题解： 递归
 */

public class TreeMaxDepth {
     //递归写法
    public int rec_maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int A = rec_maxDepth(root.left);
        int B = rec_maxDepth(root.right);

        return (A > B ? A : B) + 1;
    }

    //广度优先遍历
    public int maxDepth(TreeNode root){
        int result = 0;
        if (root == null){
            return result;
        }
        //创建一个队列
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //根节点入队
        queue.add(root);
        //如果队列不为空则没有遍历完
        while (!queue.isEmpty()){
            int n = queue.size();
            //遍历这一层，并把下一层的添加进去
            for (int i = 0; i < n; i++){
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            result ++;
        }
        return result;
    }

}
