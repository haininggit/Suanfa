package Array;

/**
 * @ClassName TheK_thNumber
 * @Description TODO  有问题
 * @Author Haining
 * @Date 2020/8/1 1:00
 * @Version 1.0
 */

/**
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。
 * 注意，不是必须有这些素因子，而是必须不包含其他的素因子。
 * 例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/get-kth-magic-number-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 面试题 17.09. 第 k 个数
 */
public class TheK_thNumber {

    public static void main(String[] args) {
        int k = 5;
        System.out.println(new TheK_thNumber().getKthMagicNumber(k));
    }

    public int getKthMagicNumber(int k) {
        int[] array = new int[k];
        int j = 0;
        int n = 1;
        int flag = 0;
        while (true){
            flag = 0;
            if (j == k){
                break;
            }
            for (int i = 2; i <= (int)Math.sqrt(n); i++) {
                if (n % i == 0){
                    flag = 1;
                    break;
                }
            }
            if (flag == 0)
                array[j++] = n;
            n++;
        }
        return array[k-1];
    }
}
