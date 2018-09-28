package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author J
 * @time 2018/9/28 20:21
 * @description
 **/
public class _56_合并区间 {
    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(o -> o.start));
        for (int i = 0; i < intervals.size() - 1; i++) {
            int j = i + 1;
            Interval itemI = intervals.get(i);
            Interval itemJ = intervals.get(j);
            if (itemJ.start <= itemI.end) {
                if (itemJ.end > itemI.end) {
                    itemI.end = itemJ.end;
                }
                intervals.remove(j);
                i--;
            }
        }
        return intervals;
    }

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 3));
        list.add(new Interval(2, 6));
        list.add(new Interval(8, 10));
        list.add(new Interval(15, 18));

        list = merge(list);
        System.out.println(list);

    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}