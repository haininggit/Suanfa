package dynamicProgramming;

/**
 * @ClassName Fibonacci
 * @Description TODO
 * @Author Haining
 * @Date 2020/7/31 22:09
 * @Version 1.0
 */

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 剑指 Offer 10- I. 斐波那契数列
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(new Fibonacci().fib(20));
        System.out.println(new Fibonacci().rec_fib(20));
    }

    public int fib(int n) {
        int[] array = new int[n+1];
        if (n == 1 || n == 2){
            return 1;
        }
        array[0] = 0;
        array[1] = 1;
        array[2] = 1;
        for(int i = 3; i < n+1; i ++){
            int num = array[i-1] + array[i-2];
            if (num > 1e9 + 7){
                num = num % (int)(1e9 + 7);
            }
            array[i] = num;
        }
        return array[n];
    }

    public int rec_fib(int n){
        if (n == 0){
            return 0;
        }
        if (n == 1 || n == 2){
            return 1;
        }

        return rec_fib(n-1) + rec_fib(n-2);
    }
}
