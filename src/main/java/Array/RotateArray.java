package Array;

/**
 * @ClassName RotateArray
 * @Description TODO
 * @Author Haining
 * @Date 2020/8/1 0:04
 * @Version 1.0
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 剑指 Offer 11. 旋转数组的最小数字
 * 解法：双指针
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] numbers = {3, 4, 5, 1, 2};
        System.out.println(new RotateArray().minArray(numbers));
    }

    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length-1;
        if (numbers.length < 2){
            return -1;
        }
        int mod = 0;
        while (left < right){
            mod = (left + right) / 2;
            if (numbers[mod] > numbers[right]){
                left = mod + 1;
            }
            else if(numbers[mod] < numbers[right]){
                right = mod;
            }
            else {
                right--;
            }
        }
        return numbers[left];
    }
}

