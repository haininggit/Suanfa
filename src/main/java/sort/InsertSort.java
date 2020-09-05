package sort;

/**
 * @ClassName InsertSort
 * @Description TODO
 * @Author Haining
 * @Date 2020/9/4 22:14
 * @Version 1.0
 */

/**
 * 每次选择一个数，进行与前面n个数进行比较，然后插入，
 */
public class InsertSort {
    public static void main(String[] args) {
        int [] arry = {8 ,7, 6 ,5, 5,4 ,4 ,2};
        arry = new InsertSort().InsertSortMethod(arry);
        for (int i : arry) {
            System.out.println(i);
        }
    }

    public int[] InsertSortMethod(int[] arry){
        int i, j, k;
        //第一层循环进行遍历每个数
        for (i = 1; i < arry.length; i++) {
            //第二层循环，比较该数与前排序号的数进行比较
            for (j = 0; j < i ; j++) {
                if (arry[i] <= arry[j]){
                    break;
                }
            }
            //如果没有遍历到i=j说明存在一个数比该数大，则该数应放在前面
            if (i != j){
                int temp = arry[i];
                //移动数组,移动i-j个数就好，所以k要大于j
                for (k = i; k > j; k --) {
                    arry[k] = arry[k - 1];
                }
                arry[j] = temp;
            }
        }
        return arry;
    }
}
