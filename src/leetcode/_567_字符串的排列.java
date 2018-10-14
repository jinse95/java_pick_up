package leetcode;

import java.util.*;

/**
 * @author J
 * @time 2018/10/14 21:25
 * @description
 **/
public class _567_字符串的排列 {


    /**
     *
     * @param s1
     * @param s2
     * @return
     * todo 待优化
     */
    public static boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len = len2 - len1 + 1;
        char[] ch1 = s1.toCharArray();
        int[] window = new int[26];
        int[] temp = new int[26];
        int tempIndex;
        //存放26个字母的次数统计
        for (char item : ch1) {
            window[item - 'a']++;
        }
        for (int i = 0; i < len; i++) {
            char item = s2.charAt(i);
            tempIndex = item - 'a';
            if (window[tempIndex] > 0) {
                temp[tempIndex]++;
                for (int j = i + 1; j < i + len1; j++) {
                    char itemJ = s2.charAt(j);
                    tempIndex = itemJ - 'a';
                    if (window[tempIndex] > 0) {
                        temp[tempIndex]++;
                    } else {
                        i = j;
                        break;
                    }
                }
                if (Arrays.equals(window, temp)) {
                    return true;
                } else {
                    for (int j = 0; j < 26; j++) {
                        temp[j] = 0;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 超时
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusionTimeOut(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len = len2 - len1 + 1;
        char[] ch1 = s1.toCharArray();
        Arrays.sort(ch1);
        for (int i = 0; i < len; i++) {
            char item = s2.charAt(i);
            List<Character> list = new ArrayList<>(len1);
            for (char cItem1 : ch1) {
                list.add(cItem1);
            }

            if (list.contains(item)) {
                list.remove((Character) item);
                for (int j = i + 1; j < i + len1; j++) {
                    char itemJ = s2.charAt(j);
                    if (Arrays.binarySearch(ch1, itemJ) < 0) {
                        i = j;
                        break;
                    }
                    if (!list.remove((Character) itemJ)) {
                        break;
                    }
                }
                if (list.size() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "rvwrk", s2 = "lznomzggwrvrkxecjaq";
        System.out.println(checkInclusion(s1, s2));
    }
}
