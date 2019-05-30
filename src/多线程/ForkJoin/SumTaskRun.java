package 多线程.ForkJoin;


import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * <a href="https://www.liaoxuefeng.com/article/1146802219354112" />
 */
public class SumTaskRun {
    public static void main(String[] args) throws Exception {
        // 创建随机数组成的数组:
        long[] array = new long[800];
        fillRandom(array);

        // fork/join task:
        ForkJoinPool fjp = new ForkJoinPool(4); // 最大并发数4
        ForkJoinTask<Long> task = new SumTask(array, 0, array.length);
        long startTime = System.currentTimeMillis();
        Long result = fjp.invoke(task);
        long endTime = System.currentTimeMillis();
        System.out.println("Fork/join sum: " + result + " in " + (endTime - startTime) + " ms.");
    }

    private static void fillRandom(long[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = RandomUtils.nextLong(0L, 100L);
        }
    }
}
