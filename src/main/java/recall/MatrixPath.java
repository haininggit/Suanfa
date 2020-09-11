package recall;

/**
 * @ClassName MatrixPath
 * @Description TODO
 * @Author Haining
 * @Date 2020/9/10 20:35
 * @Version 1.0
 */

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [['a','b','c','e'],
 * ['s','f','c','s'],
 * ['a','d','e','e']]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行
 * 第二个格子之后，路径不能再次进入这个格子。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *剑指 Offer 12. 矩阵中的路径
 *
 * 解法：回溯法
 */
public class MatrixPath {
    public static void main(String[] args) {
        char[][] board = {{'A'}};
        String word = "B";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        if (board == null || word == null){
            return false;
        }
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean dfs(char[][] board, char[] words, int i, int j, int k){
        //如果i和j越界，或者字母不匹配则会返回false
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != words[k]){
            return false;
        }
        //如果已经遍历到了最后一个字母，说明匹配上了，所以就返回true
        if (k == words.length-1){
            return true;
        }

        //临时变量用来记录已经遍历过的字母，保存的临时变量
        char temp = board[i][j];
        //修改已经遍历过的位置
        board[i][j] = '/';
        boolean res = dfs(board, words, i+1, j, k+1) || dfs(board, words, i, j+1, k+1) ||
                dfs(board, words, i-1, j, k+1) || dfs(board, words, i, j-1, k+1);
        //回溯法进行，把刚才的改变返回到修改之前
        board[i][j] = temp;

        return res;
    }
}
