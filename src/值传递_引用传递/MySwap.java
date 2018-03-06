package 值传递_引用传递;

import java.util.ArrayList;
import java.util.List;

/**
 * @author J
 * @time 2018/1/4 22:09
 * @description
 **/
public class MySwap {
    public static void swapList(List list,int i,int j){
        Object temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }

    public static <T> void swapArray(T[] arr ,int i,int j){
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = arr[i];
    }

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>(3);
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        System.out.println(integerList);
        swapList(integerList,1,2);
        System.out.println(integerList);
    }
}
