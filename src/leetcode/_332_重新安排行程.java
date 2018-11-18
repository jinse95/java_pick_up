package leetcode;

import java.util.*;

/**
 * @Description 图的深度优先遍历 Depth-First Traversa
 * @author J
 * @Date 2018/9/30 9:01
 **/
public class _332_重新安排行程 {

    public static List<String> findItinerary(String[][] tickets) {
        List<String> list = new ArrayList<>();
        Map<String, List<String>> graph = initGraph(tickets);
        String start = "JFK";
        depthFirstTraverse(list, start, graph);
        Collections.reverse(list);
        return list;
    }

    public static Map<String, List<String>> initGraph(String[][] tickets) {
        Map<String, List<String>> graph = new HashMap<>();
        for (String[] item : tickets) {
            String from = item[0];
            String to = item[1];
            List<String> toList;
            if (graph.containsKey(from)) {
                toList = graph.get(from);
                toList.add(to);
            } else {
                toList = new ArrayList<>();
                toList.add(to);
                graph.put(from, toList);
            }
        }
        for (List<String> item : graph.values()) {
            Collections.sort(item);
        }
        return graph;
    }

    public static void depthFirstTraverse(List<String> list, String start, Map<String, List<String>> graph) {
        List<String> toList = graph.get(start);
        while (toList != null && !toList.isEmpty()) {
            String to = toList.remove(0);
            depthFirstTraverse(list, to, graph);
        }
        list.add(start);
    }

    public static void main(String[] args) {
        String[][] tickets = {{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}};
        List<String> list = findItinerary(tickets);
        System.out.println(list);
    }
}
