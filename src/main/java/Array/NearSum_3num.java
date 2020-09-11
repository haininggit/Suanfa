package Array;

/**
 * @ClassName NearSum_3num
 * @Description TODO
 * @Author Haining
 * @Date 2020/9/7 23:05
 * @Version 1.0
 */

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，\
 * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 16. 最接近的三数之和
 *[-3,-2,-5,3,-4]
 * -1
 * 解法：排序+双指针
 */
public class NearSum_3num {
    public static void main(String[] args) {
        int[] nums = {-3,-2,-5,3,-4};
        System.out.println(new NearSum_3num().threeSumClosest(nums, -1));
    }
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE-1000;
        Arrays.sort(nums);  //排序
        if (nums == null && nums.length < 3){
            return -1;
        }
        for (int k = 0; k < nums.length; k++) {
            if (k > 0 && nums[k] == nums[k-1]){
                continue;
            }
            int i = k + 1, j = nums.length-1;
            while (i < j){
                if (nums[i] + nums[j] + nums[k] == target){
                    return target;
                }
                if (Math.abs((nums[i] + nums[j] + nums[k])-target) < Math.abs(min-target)){
                    min = nums[i] + nums[j] + nums[k];
                }
                else if (nums[i] + nums[j] + nums[k] > target){
                    j--;
                }
                else
                    i++;
            }
        }
        return min;
    }
}
