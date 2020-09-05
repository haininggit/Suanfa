package dynamicProgramming;

/**
 * @ClassName Massagist
 * @Description TODO
 * @Author Haining
 * @Date 2020/8/1 0:30
 * @Version 1.0
 */

import com.sun.xml.internal.ws.developer.MemberSubmissionEndpointReference;

/**
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
 * 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），
 * 返回总的分钟数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-masseuse-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 面试题 17.16. 按摩师
 */
public class Massagist {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(new Massagist().massage(nums));
    }

    public int massage(int[] nums) {
        int n = nums.length;
        int[] array = new int[n + 1];
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        array[0] = 0;
        array[1] = nums[0];
        array[2] = nums[0] > nums[1] ? nums[0] : nums[1];
        for (int i = 2; i < n; i ++){
            //如果选择这个预约
            int A = nums[i] + array[i - 1];
            //如果不选择这个预约
            int B = array[i];
            array[i + 1] = A > B ? A : B;
        }
        return array[n];
    }
}
