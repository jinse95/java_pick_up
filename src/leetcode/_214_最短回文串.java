package leetcode;

/**
 * @Author J
 * @Date 2018/10/17 13:44
 * @Description
 * todo  kmp 优化
 **/
public class _214_最短回文串 {
    public static String shortestPalindrome(String s) {

        int c = isPalindromeString(s);
        if (c == -1) {
            return new StringBuilder(s.substring(1)).reverse().append(s).toString();
        } else if (c == 0) {
            return s;
        }

        return new StringBuilder(s.substring(c)).reverse().append(s).toString();
    }

    public static int isPalindromeString(String s) {
        int len0 = s.length();
        int len = len0 / 2;
        int s0, s1;

        boolean even = len0 % 2 == 0;
        /**
         * 判断本身是否对称
         */
        if (even) {
            s1 = len;
            s0 = s1 - 1;
        } else {
            s0 = len - 1;
            s1 = s0 + 2;
        }

        s0 = checkStrChar(s, s0, s1);
        if (s0 == -1) {
            return 0;
        }

        len--;
        while (len > 0) {
            //两边对称
            if (even) {
                s1 = len;
                s0 = s1 - 1;
            } else {
                s0 = len;
                s1 = s0 + 1;
            }

            s0 = checkStrChar(s, s0, s1);
            if (s0 == -1) {
                return 2 * s1;
            }

            //中心对称
            s0 = len - 1;
            s1 = len + 1;
            s0 = checkStrChar(s, s0, s1);
            if (s0 == -1) {
                return 2 * len + 1;
            }

            len--;
        }
        if (!even) {
            if (s.charAt(0) == s.charAt(1)) {
                return 2;
            }
//            s0 = 0;
//            s1 = 1;
//            s0 = checkStrChar(s, s0, s1);
//            if (s0 == -1) {
//                return 2 * s1;
//            }
        }
        return -1;
    }

    private static int checkStrChar(String s, int s0, int s1) {
        while (s0 >= 0) {
            if (s.charAt(s0) != s.charAt(s1)) {
                break;
            }
            s0--;
            s1++;
        }
        return s0;
    }

    public static void main(String[] args) {
        String s = "aabba";
        int c = isPalindromeString(s);
        System.out.println(c);
        System.out.println(shortestPalindrome(s));
    }
}
