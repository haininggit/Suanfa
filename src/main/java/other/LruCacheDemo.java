package other;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LruCacheDemo
 * @Description TODO
 * @Author Haining
 * @Date 2020/8/7 17:16
 * @Version 1.0
 */

/**
 * 设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。
 * 缓存应该从键映射到值(允许你插入和检索特定键对应的值)，
 * 并在初始化时指定最大容量。当缓存被填满时，
 * 它应该删除最近最少使用的项目。
 *
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，
 * 则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，
 * 则写入其数据值。当缓存容量达到上限时，
 * 它应该在写入新数据之前删除最近最少使用的数据值，
 * 从而为新的数据值留出空间。
 *
 *
 * 面试题 16.25. LRU缓存
 *
 * 解法：哈希表加链表
 */
public class LruCacheDemo {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.show();
        lruCache.put(2, 2);
        lruCache.show();
        System.out.println(lruCache.get(1));
        lruCache.show();
        lruCache.put(3, 3);
        lruCache.show();
        System.out.println(lruCache.get(2));
        lruCache.show();

    }
}

class LRUCache {
    static int[] arr;
    static Map map;
    int count = 0;
    int capacity = 0;
    public LRUCache(int capacity) {
        this.arr = new int[capacity];
        this.map = new HashMap<Integer, Integer>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Object val = map.get(key);
        if(val != null){
            for(int i = 0; i < count; i++){
                //如果第一个就是，就不需要移动
                if(arr[0] == key){
                    break;
                }
                //如果使用了该数，则该数往数组前面走，而数组最后的就是最少使用的
                if(arr[i] == key){
                    int temp = arr[i];
                    for (int j = i; j > 0 ; j--) {
                        arr[j] = arr[j - 1];
                    }
                    arr[0] = temp;
                }
            }
            return (Integer)val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Object val = map.get(key);
        //如果有该数，则会进行修改
        if (val != null){
            map.put(key, value);
            for(int i = 0; i < count; i++){
                //如果第一个就是，就不需要移动
                if(arr[0] == key){
                    break;
                }
                //如果使用了该数，则该数往数组前面走，而数组最后的就是最少使用的
                if(arr[i] == key){
                    int temp = arr[i];
                    for (int j = i; j > 0 ; j--) {
                        arr[j] = arr[j - 1];
                    }
                    arr[0] = temp;
                }
            }
        }

        //如果没有该数，则会判断容量，并添加；
        if(val == null){
            //如果容量没有满，则进行添加
            if(count < capacity){
                for(int i = count; i > 0; i--){
                    arr[i] = arr[i - 1];
                }
                arr[0] = key;
                map.put(key, value);
                count ++;
            }
            //如果容量满了，则进行删除
            else{
                int num = arr[count - 1];
                map.remove(num);
                for(int i = count - 1; i > 0; i--){
                    arr[i] = arr[i - 1];
                }
                arr[0] = key;
                map.put(key, value);
            }
        }
    }

    public void show(){
        System.out.print("arr" + "  ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
        System.out.print("map" + "  ");
        for (Object o : map.keySet()) {
            Integer key = (Integer)o;
            System.out.print(key +": " + map.get(key) + ",");
        }
        System.out.println();
        System.out.println("count" + count);
    }
}
