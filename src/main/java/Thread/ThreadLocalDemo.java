package Thread;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadLocalDemo
 * @Description TODO
 * @Author Haining
 * @Date 2020/8/19 16:10
 * @Version 1.0
 */
public class ThreadLocalDemo {

    static ThreadLocal<T> t1 = new ThreadLocal();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(t1.get());
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                try{
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                t1.set(new T());
            }
        }).start();
    }
}
