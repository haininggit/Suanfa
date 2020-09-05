package Array;

/**
 * @ClassName Sum_3num
 * @Description TODO
 * @Author Haining
 * @Date 2020/8/5 8:56
 * @Version 1.0
 */

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 15. 三数之和
 * 解法：双指针
 */
public class Sum_3num{
    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {0, 0, 0};
        List<List<Integer>> lists = new Sum_3num().threeSum(nums);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        //对数组进行排序
        Arrays.sort(nums);
        //创建容器
        List<List<Integer>> listList = new ArrayList<List<Integer>>();
        //如果长度小于3则返回null
        if (nums == null || nums.length < 3){
            return listList;
        }
        //第一层循环，确定一个数
        for (int k = 0; k < nums.length; k++) {
            //k == 0肯定要进去的，所以加一个k > 0，
            //如果确定的这个数跟后面一个相等，则会往后移
            if (k > 0 && nums[k] == nums[k-1]){
                continue;
            }
            //i 是因为不重复，所以每次只再确定的数后面找，就不会出现重复，因为是排序的
            int i = k+1, j = nums.length-1;
            while (i < j){
                //如果三个数加和为0，则放入容器
                if (nums[i] + nums[j] + nums[k] == 0){
                    List list = new ArrayList();
                    list.add(nums[k]);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    listList.add(list);
                    //这两步相当于调优
                    //如果第i个数跟第i+1个数相等，则会跳过，避免重复的
                    while (i < j && nums[i] == nums[i + 1]){
                        i++;
                    }
                    i++;
                    //如果第j个数跟第j+1个数相等，则会跳过，避免重复的
                    while (i < j && nums[j] == nums[j - 1]){
                        j--;
                    }
                    j--;
                }
                //如果加和小于0，则i会加1
                else if(nums[i] + nums[j] < 0 - nums[k]){
                    i++;
                }
                //如果加和大于0，则减小1
                else {
                    j--;
                }
            }
        }
        return listList;
    }
}
