package dynamicProgramming;

/**
 * @ClassName CutRope
 * @Description TODO
 * @Author Haining
 * @Date 2020/9/10 22:00
 * @Version 1.0
 */

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 剑指 Offer 14- I. 剪绳子
 *
 * 解法：cuttingRope()动态规划
 *       tanxinRope()贪心算法：尽可能的乘以3，剩余4的时候进行2*2
 */
public class CutRope {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(cuttingRope(n));
        System.out.println(tanxinRope(n));
    }
    public static int cuttingRope(int n) {
        if (n < 2){
            return 0;
        }
        if (n == 2){
            return 1;
        }
        if (n == 3){
            return 2;
        }
        int[] arry = new int[n+1];
        arry[0] = 0;
        arry[1] = 1;
        arry[2] = 2;
        arry[3] = 3;
        int max = 0;
        for (int i = 4; i < n+1; i++) {
            max = 0;
            for (int j = 1; j <= i/2; j++) {
                int res = arry[j] * arry[i-j];
                if (max < res){
                    max = res;
                }
                arry[i] = max;
            }
        }
        return arry[n];
    }

    public static int tanxinRope(int n){
        int m = n;
        if (n < 2){
            return 0;
        }
        if (n == 2){
            return 1;
        }
        if (n == 3){
            return 2;
        }
        int count = 1;
        while (m != 4 && m > 3){
            m -= 3;
            count *= 3;
        }
        if (m == 4){
            return count * 4;
        }
        return count * m;
    }
}
