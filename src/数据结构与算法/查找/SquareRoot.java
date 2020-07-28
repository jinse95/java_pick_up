package 数据结构与算法.查找;

/**
 * @author J
 */
public class SquareRoot {

    /**
     * 平方根6位小数
     *
     * @param d
     * @return
     */
    public static double squareRoot(double d) {
        if (d == 1 || d == 0) {
            return d;
        } else if (d < 0) {
            return -1;
        }

        double low, high;
        if (d < 1) {
            low = d;
            high = 1;
        } else {
            low = 1;
            high = d;
        }

        //精度
        double jd = 1e-6;
        double mid;
        double mid2;
        while (true) {
            mid = (high + low) / 2;
            //2次方
            mid2 = Math.pow(mid, 2);
            if (Math.abs(mid2 - d) < jd) {
                return Double.valueOf(String.format("%.6f", mid));
            } else if (mid2 > d) {
                high = mid;
            } else {
                low = mid;
            }
        }
    }


    /**
     * 平方根整数
     *
     * @param x
     * @return
     */
    public static int squareIntRoot(int x) {
        if (x < 1) {
            return 0;
        }

        long low = 1, high = x;

        long mid;
        //平方有可能溢出
        long midPow2;
        while (low < high) {
            mid = low + (high - low) / 2;
            midPow2 = mid * mid;
            if (midPow2 == x) {
                return (int) mid;
            }

            if (midPow2 < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (low * low > x) {
            low = low - 1;
        }

        return (int) low;
    }


    public static void main(String[] args) {
        System.out.println(squareIntRoot(1));
        System.out.println(squareIntRoot(2));
        System.out.println(squareIntRoot(3));
        System.out.println(squareIntRoot(4));
        System.out.println(squareIntRoot(5));
        System.out.println(squareIntRoot(8));
        System.out.println(squareIntRoot(9));
        System.out.println(squareIntRoot(63));
        System.out.println(squareIntRoot(64));
        System.out.println(squareIntRoot(2147395599));
    }
}
