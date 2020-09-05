package Array;

/**
 * @ClassName Container_With_Most_Water
 * @Description TODO
 * @Author Haining
 * @Date 2020/8/5 11:58
 * @Version 1.0
 */

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 11. 盛最多水的容器
 *
 * 解法：双指针
 */
public class Container_With_Most_Water {
    public static void main(String[] args) {
        int[] height = {1, 2, 4, 3};
//        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(new Container_With_Most_Water().maxArea(height));
    }

    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int max = 0;
        int i = 0, j = height.length-1;
        while(i < j){
            int n = (height[i] < height[j] ? height[i] : height[j]) * (j - i);
            if(n > max){
                max = n;
            }
            if(height[i] < height[j]){
                if (height[i] > height[i + 1]){
                    while(i < j && height[i] > height[i + 1]){
                        i ++;
                    }
                }else {
                    i++;
                }
            }
            else{
                if (height[j] > height[j - 1]){
                    while(i < j && height[j] > height[j - 1]){
                        j --;
                    }
                }else {
                    j--;
                }
            }
        }
        return max;
    }
}
