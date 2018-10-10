package utils;

import java.util.List;

/**
 * @Description 基础工具类
 * @Author J
 * @Date 2018/10/9 8:41
 **/
public class BaseUtils {
    private BaseUtils() {
    }


    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static <T> void swap(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
