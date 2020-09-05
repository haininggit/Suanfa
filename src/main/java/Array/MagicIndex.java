package Array;

/**
 * @ClassName MagicIndex
 * @Description TODO
 * @Author Haining
 * @Date 2020/7/31 21:27
 * @Version 1.0
 */

/**
 *该题为魔术索引
 * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。
 * 给定一个有序整数数组，
 * 编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。
 * 若有多个魔术索引，返回索引值最小的一个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/magic-index-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 面试题 08.03. 魔术索引
 * 解法：双指针
 */
public class MagicIndex {
    public static void main(String[] args) {
        int[] nums = {0, 0, 2};
        System.out.println(new MagicIndex().findMagicIndex(nums));
    }
    public int findMagicIndex(int[] nums) {
        int mod = 0;
        if (nums == null) return -1;
        int left = 0, right = nums.length;
        if (right == 1){
            if (nums[left] == 0){
                return 0;
            }
            return -1;
        }
        while (left <= right){
            mod = (left + right) / 2;
            if (nums[mod] == mod){
                for (int i = left ; i < mod; i++){
                    if (nums[i] == i){
                        return i;
                    }
                }
                return mod;
            }
            if (nums[mod] > mod){
                right = mod - 1;
            }
            else {
                if (nums[mod] >= 0 && nums[nums[mod]] == nums[mod]){
                    return nums[mod];
                }
                left = mod + 1;
            }
        }
        return -1;
    }
}
