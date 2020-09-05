package Array;

/**
 * @ClassName Move_Zeroes
 * @Description TODO
 * @Author Haining
 * @Date 2020/8/5 8:38
 * @Version 1.0
 */

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，
 * 同时保持非零元素的相对顺序。
 *
 *283. 移动零
 */
public class Move_Zeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new Move_Zeroes().moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                //如果没遇到0，则会自己跟自己换，如果遇到0了，则会把0往后放
                nums[j] = nums[i];
                //i往前移的时候，i位置上的数应该为0
                if (i != j){
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
