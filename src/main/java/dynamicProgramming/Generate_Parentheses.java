package dynamicProgramming;

/**
 * @ClassName Generate_Parentheses
 * @Description TODO
 * @Author Haining
 * @Date 2020/8/5 13:24
 * @Version 1.0
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，
 * 用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 22. 括号生成
 * 解法：递归加剪枝
 */
public class Generate_Parentheses {
    public static void main(String[] args) {
        int n = 3;
        List<String> list = new Generate_Parentheses().generateParenthesis(n);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public List<String> generateParenthesis(int n) {
        List list = new ArrayList<String>();
        helper(0, 0, n, list, "");
        return list;
    }

    public void helper(int left, int right, int n, List<String> list, String s){
        if (left == n && right == n){
            list.add(s);
            return;
        }
        if (left < n)
            helper(left + 1, right, n, list, s + "(");
        if (left > right)
            helper(left, right+1, n, list, s + ")");
    }
}
