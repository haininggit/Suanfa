package Array;

/**
 * @ClassName RemoveDuplicates
 * @Description TODO
 * @Author Haining
 * @Date 2020/8/8 23:34
 * @Version 1.0
 */

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，
 * 使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组
 * 并在使用 O(1) 额外空间的条件下完成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 26. 删除排序数组中的重复项
 *先把数组中重复的数字都更换为Integer.MIN_VALUE，然后把Integer.MIN_VALUE往数组的后面进行移动
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(new RemoveDuplicates().removeDuplicatesFirst(nums));
        for (int num : nums) {
            System.out.print(num + ", ");
        }
    }
    public int removeDuplicatesFirst(int[] nums) {
        int length = nums.length;
        if (length == 0 || length == 1){
            return length;
        }
        for(int i = 0; i < nums.length - 1; i ++){
            if(nums[i] == nums[i+1]){
                nums[i] = Integer.MIN_VALUE;
                length--;
            }
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MIN_VALUE){
                //如果没遇到Integer.MIN_VALUE，则会自己跟自己换，如果遇到Integer.MIN_VALUE了，则会把Integer.MIN_VALUE往后放
                nums[j] = nums[i];
                //i往前移的时候，i位置上的数应该为Integer.MIN_VALUE
                if (i != j){
                    nums[i] = 0;
                }
                j++;
            }
        }
        return length;
    }

    public int removeDuplicatesTow(int[] nums){
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[count] != nums[i])
                count++;
            nums[count] = nums[i];
        }
        return count;
    }

}
