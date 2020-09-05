package dynamicProgramming;

/**
 * @ClassName HouseRobber_ii
 * @Description TODO
 * @Author Haining
 * @Date 2020/8/7 18:54
 * @Version 1.0
 */



/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，
 * 系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，
 * 能够偷窃到的最高金额。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 213. 打家劫舍 II
 *
 * 题解：动态规划
 */
public class HouseRobber_ii {
    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        System.out.println(new HouseRobber_ii().rob(nums));

    }


    public int rob(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] nums1 = new int[nums.length-1];
        int[] nums2 = new int[nums.length-1];
        System.arraycopy(nums, 0, nums1, 0,nums.length - 1);
        System.arraycopy(nums, 1, nums2, 0,nums.length - 1);
        return Math.max(helper(nums1), helper(nums2));
    }

    public int helper(int[] nums){
        int res1 = nums[0];
        int res2 = Math.max(nums[0], nums[1]);
        int res = 0;
        for(int i = 2;i < nums.length; i++){
            res = Math.max(nums[i] + res1, res2);
            res1 = res2;
            res2 = res;
        }
        return res2;
    }
}
