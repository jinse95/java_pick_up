package 机器学习.聚类;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * @Author J
 * @Date 2018/7/10 15:34
 **/
public class KMeansIris {

    /**
     * 加载iris 文件
     *
     * @param url
     * @return
     */
    public static List<Iris> loadData(String url) {
        List<Iris> irisList = new ArrayList<>();
        //加载测试的数据文件
        try {
            //读入文件
            Scanner in = new Scanner(new File(url));
            while (in.hasNextLine()) {
                //将文件的每一行存到str的临时变量中
                String str = in.nextLine();
                if (str != null && str.length() > 0) {
                    String[] properties = str.split(" ");
                    Iris iris = new Iris();
                    //第一项是编号 从第二项开始取
                    iris.setSepalLength(Double.valueOf(properties[1]));
                    iris.setSepalWidth(Double.valueOf(properties[2]));
                    iris.setPetalLength(Double.valueOf(properties[3]));
                    iris.setPetalWidth(Double.valueOf(properties[4]));
                    iris.setSpecies(properties[5]);

                    irisList.add(iris);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return irisList;
    }


    /**
     * 重新计算中心
     *
     * @param irisList
     * @return
     */
    public static Iris getCenter(List<Iris> irisList) {
        Iris iris = null, irisI, irisJ;
        int len = irisList.size();
        int i = 0, j = len - 1;
        //存放已经计算过的距离缓存
        HashMap<Integer, Double> cache = new HashMap<>(len / 2);
        while (i < j) {

            irisI = irisList.get(i);
            double iDistance = 0;
            if (cache.containsKey(i)) {
                iDistance = cache.get(i);
            } else {
                for (Iris item : irisList) {
                    iDistance += calculateDistance(irisI, item);
                }
            }

            irisJ = irisList.get(j);
            double jDistance = 0;
            if (cache.containsKey(j)) {
                jDistance = cache.get(j);
            } else {
                for (Iris item : irisList) {
                    jDistance += calculateDistance(irisJ, item);
                }
            }

            if (iDistance >= jDistance) {
                i++;
                iris = irisJ;
                cache.put(j, jDistance);
            } else {
                j--;
                iris = irisI;
                cache.put(i, iDistance);
            }
        }
        return iris;
    }

    public static void printList(List<Iris> irisList) {
        System.out.println("--------------------------------------");
        for (Iris item : irisList) {
            System.out.println(item);
        }
    }


    public static void main(String[] args) {
        List<Iris> irisList = loadData("d:/iris.txt");

        printList(irisList);


        List<Iris> irisList1 = new ArrayList<>();
        List<Iris> irisList2 = new ArrayList<>();
        List<Iris> irisList3 = new ArrayList<>();

        Iris center1 = irisList.get(10);
        Iris center2 = irisList.get(50);
        Iris center3 = irisList.get(60);

        for (Iris item : irisList) {

            double a = calculateDistance(item, center1);
            double b = calculateDistance(item, center2);
            double c = calculateDistance(item, center3);

            double min = Math.min(a, Math.min(b, c));
            if (min == a) {
                irisList1.add(item);
            } else if (min == b) {
                irisList2.add(item);
            } else if (min == c) {
                irisList3.add(item);
            }
        }


        Iris center10 = getCenter(irisList1), center20 = getCenter(irisList2), center30 = getCenter(irisList3);
        while (!center1.equals(center10) || !center2.equals(center20) || !center3.equals(center30)) {
            center1 = center10;
            center2 = center20;
            center3 = center30;

            irisList1 = new ArrayList<>();
            irisList2 = new ArrayList<>();
            irisList3 = new ArrayList<>();

            for (Iris item : irisList) {

                double a = calculateDistance(item, center1);
                double b = calculateDistance(item, center2);
                double c = calculateDistance(item, center3);

                double min = Math.min(a, Math.min(b, c));
                if (min == a) {
                    irisList1.add(item);
                } else if (min == b) {
                    irisList2.add(item);
                } else if (min == c) {
                    irisList3.add(item);
                }
            }
            //重新计算中心
            center10 = getCenter(irisList1);
            center20 = getCenter(irisList2);
            center30 = getCenter(irisList3);
        }

        printList(irisList1);
        printList(irisList2);
        printList(irisList3);


        System.out.println("ok");
    }

    /**
     * 计算欧式距离
     *
     * @param iris1
     * @param iris2
     * @return
     */
    private static Double calculateDistance(Iris iris1, Iris iris2) {
        double distance = Math.pow((iris1.getSepalLength() - iris2.getSepalLength()), 2)
                + Math.pow((iris1.getSepalWidth() - iris2.getSepalWidth()), 2)
                + Math.pow((iris1.getPetalLength() - iris2.getPetalLength()), 2)
                + Math.pow((iris1.getPetalWidth() - iris2.getPetalWidth()), 2);
        distance = Math.sqrt(distance);
        return distance;
    }

}
