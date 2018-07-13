package 机器学习.分类.决策树;

import java.io.File;
import java.util.*;

/**
 * @Description
 * @Author J
 * @Date 2018/7/12 17:12
 **/
public class ID3 {
    /**
     * 存放向量属性的名字
     */
    public static List<String> keyList;

    /**
     * 存放每个属性对应的所有值 key  valueSet<>
     */
    public static Map<String, Set<String>> valueMap;

    /**
     * 存放已经处理过的属性
     */
    public static List<String> keyDealed = new ArrayList<>();

    /**
     * 分类的属性
     */
    public static String typeKey;

    /**
     * 加载数据文件
     * 文件格式 第一行为属性名字 最后一个为结果值,值之间以单个空格隔开
     *
     * @param url
     * @return
     */
    public static List<Map<String, String>> loadData(String url) {
        List<Map<String, String>> dataList = new ArrayList<>();
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
                            data.put(keyList.get(i), properties[i]);
                        }
                        dataList.add(data);
                    } else {
                        //构造属性列表
                        keyList = new ArrayList<>();
                        Collections.addAll(keyList, properties);
                        //目标属性key
                        typeKey = properties[properties.length - 1];

                        valueMap = new HashMap<>();
                        for (String item : properties) {
                            valueMap.put(item, new HashSet<>());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataList;
    }

    /**
     * 获取最大信息增益的key
     *
     * @return
     */
    public static String getMaxEntropyUpKey() {
        List<Map<String, String>> dataList = loadData("d:/dTree.txt");
        double entropy0 = calculateInfoEntropy(typeKey, dataList);
        String maxEntropyUpKey = "";
        double maxEntropy = 0;
        //暂时没用
        List<Map<String, Object>> entropyList = new ArrayList<>();
        for (String key : keyList) {
            double getEntropy = calculateInfoEntropy(key, dataList);
            if (!key.equals(typeKey)) {
                Map<String, Object> item = new HashMap<>(2);
                item.put("key", key);
                item.put("value", entropy0 - getEntropy);
                entropyList.add(item);

                if (entropy0 - getEntropy > maxEntropy) {
                    maxEntropy = entropy0 - getEntropy;
                    maxEntropyUpKey = key;
                }
            }
        }

        //按信息增益从大到小排序
        entropyList.sort((o1, o2) -> ((Double) o2.get("value")).compareTo((Double) o1.get("value")));

        return maxEntropyUpKey;
    }

    /**
     * 计算信息熵
     *
     * @return
     */
    private static double calculateInfoEntropy(String key, List<Map<String, String>> dataList) {
        //样本总数
        int num = dataList.size();

        Map<String, Long> countMap = new HashMap<>();
        for (Map<String, String> item : dataList) {
            String value = item.get(key);
            if (countMap.containsKey(value)) {
                countMap.put(value, countMap.get(value) + 1);
            } else {
                countMap.put(value, 1L);

                Set<String> temp = valueMap.get(key);
                temp.add(value);
                valueMap.put(key, temp);
            }
        }

        double entropy = 0;
        //总的信息熵
        if (key.equals(typeKey)) {
            for (long itemValue : countMap.values()) {
                double p = itemValue * 1.0 / num;
                entropy += -p * (Math.log(p) / Math.log(2));
            }
        } else {
            for (Map.Entry<String, Long> item : countMap.entrySet()) {
                String itemKey = item.getKey();
                long itemValue = item.getValue();

                //获取指定的key 对应的结果映射统计
                Map<String, Long> resultKeyMap = new HashMap<>();
                for (Map<String, String> data : dataList) {

                    String getValueByKey = data.get(key);

                    if (getValueByKey.equals(itemKey)) {
                        String value = data.get(typeKey);
                        if (resultKeyMap.containsKey(value)) {
                            resultKeyMap.put(value, resultKeyMap.get(value) + 1);
                        } else {
                            resultKeyMap.put(value, 1L);
                        }
                    }
                }

                //计算
                for (Long getValue : resultKeyMap.values()) {
                    double p = getValue * 1.0 / itemValue;
                    entropy += -(itemValue * 1.0 / num) * p * (Math.log(p) / Math.log(2));
                }
            }
        }
        return entropy;
    }


    public static void main(String[] args) {
        System.out.println(getMaxEntropyUpKey());
    }
}
