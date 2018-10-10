package leetcode;

/**
 * @author J
 * @time 2018/9/28 20:49
 * @description
 **/
public class _459_重复的子字符串 {

    public static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int len1 = len / 2;
        //子串长度
        for (int sonLen = 1; sonLen <= len1; sonLen++) {
            if (len % sonLen != 0) {
                continue;
            }

            //子串数量
            int sonNum = len / sonLen;
            boolean flag = false;
            //比较每个子串是否相等
            for (int sonIndex = 0; sonIndex < sonNum - 1; sonIndex++) {
                //比较字串的每一位是否相等
                for (int k = 0; k < sonLen; k++) {
                    if (s.charAt(sonLen * sonIndex + k) != s.charAt(sonLen * (sonIndex + 1) + k)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            if (!flag) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("a"));
    }
}
