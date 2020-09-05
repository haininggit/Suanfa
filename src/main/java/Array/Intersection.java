package Array;

/**
 * @ClassName Intersection
 * @Description TODO
 * @Author Haining
 * @Date 2020/8/6 14:47
 * @Version 1.0
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 350. 两个数组的交集 II
 * 解法：哈希表
 */
public class Intersection {
    public static void main(String[] args) {

    }

    public int[] intersect(int[] nums1, int[] nums2){
        if (nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }

        Map map = new HashMap<Integer, Integer>();
        List list = new ArrayList<Integer>();
        for (int num : nums1) {
            if (map.get(num) == null){
                map.put(num, 1);
                continue;
            }
            map.put(num, ((Integer)map.get(num) + 1));
        }
        for (int num : nums2) {
            if (map.get(num) == null || (Integer) map.get(num) == 0){
                continue;
            }
            list.add(num);
            map.put(num, (Integer)map.get(num) - 1);
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = (Integer) list.get(i);
        }
        return nums;
    }
}
