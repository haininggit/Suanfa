package Tree;

/**
 * @ClassName BFS
 * @Description TODO
 * @Author Haining
 * @Date 2020/8/6 22:56
 * @Version 1.0
 */

import java.util.*;

/**
 * 广度优先算法遍历树
 *
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 */
public class BFS {
    public int[] BFSTree(TreeNode root){
        if (root == null){
            return new int[0];
        }
        //创建一个数组存储元素
        List list = new ArrayList<Integer>();
        //创建一个队列
        Queue queue = new LinkedList<TreeNode>();
        //根节点入队列
        queue.add(root);
        //直到队列遍历为空，则所有数据遍历完毕
        while (!queue.isEmpty()) {
            //当前节点出队列，把孩子节点如队列
            TreeNode node = (TreeNode) queue.poll();
            list.add(node.val);
            //如果左孩子不为空，则入队
            if (node.left != null) {
                queue.add(node.left);
            }
            //如果右孩子不为空，则入队
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = (Integer) list.get(i);
        }
        return arr;
    }
}
