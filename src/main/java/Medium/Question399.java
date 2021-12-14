package Medium;

import java.util.*;

public class Question399 {

    class Node {
        private String name;
        private double num;

        Node(String name, double num) {
            this.name = name;
            this.num = num;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> map = new HashMap<>(); // 邻接图

        for (int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);

            if (!map.containsKey(dividend)) {
                map.put(dividend, new ArrayList<>());
            }
            if (!map.containsKey(divisor)) {
                map.put(divisor, new ArrayList<>());
            }

            map.get(dividend).add(new Node(divisor, values[i]));
            map.get(divisor).add(new Node(dividend, 1 / values[i]));
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            res[i] = dfs(query.get(0), query.get(1), 1.0, map, new HashSet<>());
        }
        return res;
    }

    private double dfs(String cur, String end, double multiple, Map<String, List<Node>> map, Set<String> path) {
        if (path.contains(cur) || !map.containsKey(cur)) {
            return -1.0;
        }
        if (cur.equals(end)) {
            return multiple;
        }

        path.add(cur);
        for (Node node: map.get(cur)) {
            double res = dfs(node.name, end, multiple*node.num, map, path);
            if (res != -1.0) {
                return res;
            }
        }

        return -1.0;
    }

    public static void main(String[] args) {
        Question399 question = new Question399();
        List<List<String>> equations = new ArrayList<>(Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c")
        ));
        double[] values = new double[]{2.0, 3.0};
        List<List<String>> queries = new ArrayList<>(Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x")
        ));
        utils.Output.outputInLine(Arrays.stream(
                question.calcEquation(equations, values, queries)
        ).boxed().toArray(Double[]::new));
    }
}
