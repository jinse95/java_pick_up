package 机器学习.分类.决策树;

import java.io.File;
import java.util.*;

/**
 * @Description 决策树
 * @Author J
 * @Date 2018/7/11 18:03
 **/
public class DecisionTree {

    /**
     * 存放向量属性的名字
     */
    public static List<String> propertyList;

    /**
     * 加载数据文件
     *
     * @param url
     * @return
     */
    public static List<Map> loadData(String url) {
        List<Map> dataList = new ArrayList<>();
        //加载测试的数据文件
        try {
            //读入文件
            Scanner in = new Scanner(new File(url));
            int count = 0;
            while (in.hasNextLine()) {
                //计数+1
                count++;
                String str = in.nextLine();
                if (str != null && str.length() > 0) {
                    String[] properties = str.split(" ");
                    if (count > 1) {
                        Map<String, String> data = new HashMap<>();
                        for (int i = 0; i < properties.length; i++) {
                            data.put(propertyList.get(i), properties[i]);
                        }
                        dataList.add(data);
                    } else {
                        //构造属性列表
                        propertyList = new ArrayList<>();
                        Collections.addAll(propertyList, properties);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;
    }

    /**
     * 计算信息熵
     *
     * @return
     */
    private double calculateInfoEntropy() {

    }

}
