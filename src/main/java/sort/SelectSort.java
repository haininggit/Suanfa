package sort;

/**
 * @ClassName SelectSort
 * @Description TODO
 * @Author Haining
 * @Date 2020/9/4 22:56
 * @Version 1.0
 */



/**
 * 选择排序，在未排序数组中挑选最大或者最小的放在数组前面，大小的区别是升序或者降序
 */
public class SelectSort {
    public static void main(String[] args) {
        int [] arry = {8 ,7, 6 ,5, 5,4 ,4 ,2};
        arry = new SelectSort().SelectSortMothod(arry);
        for (int i : arry) {
            System.out.println(i);
        }
    }
    public int[] SelectSortMothod(int[] arry){
        for (int i = 0; i < arry.length; i++) {
            int min = i;
            for (int j = i + 1; j < arry.length; j++) {
                if (arry[j] < arry[min]){
                    min = j;
                }
            }
            int temp = arry[i];
            arry[i] = arry[min];
            arry[min] = temp;
        }
        return arry;
    }
}
