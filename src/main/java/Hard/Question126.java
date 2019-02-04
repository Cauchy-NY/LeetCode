package Hard;

import java.util.*;

public class Question126 {
    public List<List<String>> findLadders(String start, String end, List<String> wordList) {
        HashSet<String> dict = new HashSet<String>(wordList);
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<String, ArrayList<String>>();// Neighbors for every node
        HashMap<String, Integer> distance = new HashMap<String, Integer>();// Distance of every node from the start node
        ArrayList<String> solution = new ArrayList<String>();

        dict.add(start);
        bfs(start, end, dict, nodeNeighbors, distance);
        dfs(start, end, dict, nodeNeighbors, distance, solution, res);
        return res;
    }

    // BFS: Trace every node's distance from the start node (level by level).
    private void bfs(String start, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance) {
        for (String str : dict)
            nodeNeighbors.put(str, new ArrayList<String>());

        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        distance.put(start, 0);

        while (!queue.isEmpty()) {
            int count = queue.size();
            boolean foundEnd = false;
            for (int i = 0; i < count; i++) {
                String cur = queue.poll();
                int curDistance = distance.get(cur);
                ArrayList<String> neighbors = getNeighbors(cur, dict);

                for (String neighbor : neighbors) {
                    nodeNeighbors.get(cur).add(neighbor);
                    if (!distance.containsKey(neighbor)) {// Check if visited
                        distance.put(neighbor, curDistance + 1);
                        if (end.equals(neighbor))// Found the shortest path
                            foundEnd = true;
                        else
                            queue.offer(neighbor);
                    }
                }
            }

            if (foundEnd)
                break;
        }
    }

    // DFS: output all paths with the shortest distance.
    private void dfs(String cur, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
        solution.add(cur);
        if (end.equals(cur)) {
            res.add(new ArrayList<String>(solution));
        } else {
            for (String next : nodeNeighbors.get(cur)) {
                if (distance.get(next) == distance.get(cur) + 1) {
                    dfs(next, end, dict, nodeNeighbors, distance, solution, res);
                }
            }
        }
        solution.remove(solution.size() - 1);
    }

    // Find all next level nodes.
    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        char chs[] = node.toCharArray();

        for (char ch ='a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }

//    private Map<String, List<String>> neighbors = new HashMap<>();
//
//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        List<List<String>> res = new ArrayList<>();
//        Set<String> wordSet = new HashSet<>(wordList);
//        Set<String> visited = new HashSet<>();
//        visited.add(beginWord);
//        wordSet.remove(beginWord);
//
//        // bfs 直至找到 endWord，找不到返回空集
//        while (!visited.contains(endWord)) {
//            Set<String> temp = new HashSet<>();
//            for (String word : visited) {
//                for (int i = 0; i < word.length(); i++) {
//                    char[] chars = word.toCharArray();
//                    for (char c = 'a'; c <= 'z'; c++) {
//                        chars[i] = c;
//                        String newWord = new String(chars);
//                        if (wordSet.contains(newWord)) {
//                            temp.add(newWord);
//                            /**
//                             * 这里不用队列解决不了，有问题
//                             */
//                            if (!newWord.equals(endWord))
//                                wordSet.remove(newWord);
//
//                            if (neighbors.containsKey(word))
//                                neighbors.get(word).add(newWord);
//                            else {
//                                List<String> nextLevel = new ArrayList<>();
//                                nextLevel.add(newWord);
//                                neighbors.put(word, nextLevel);
//                            }
//                        }
//                    }
//                }
//            }
//            if (temp.size() == 0)
//                return res;
//            visited = temp;
//        }
//
//        // 找得到 backWord，进行 dfs 记录路径
//        List<String> list = new ArrayList<>();
//        list.add(beginWord);
//        backtrack(res, list, beginWord, endWord);
//
//        return res;
//    }
//
//    private void backtrack(List<List<String>> res, List<String> tmp, String beginWord, String endWord) {
//        if (beginWord.equals(endWord)) {
//            res.add(new ArrayList<>(tmp));
//            return;
//        }
//
//        if (!neighbors.containsKey(beginWord)) {
//            return;
//        } else {
//            List<String> nextLevel = neighbors.get(beginWord);
//            for (String word: nextLevel) {
//                tmp.add(word);
//                backtrack(res, tmp, word, endWord);
//                tmp.remove(word);
//            }
//        }
//    }

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("red");
        wordList.add("ted");
        wordList.add("tex");
        wordList.add("tax");
        wordList.add("tad");
        wordList.add("rex");
        List<List<String>> res = new Question126().findLadders("red", "tax", wordList);
        for (List<String> list: res) {
            for (String word: list)
                System.out.print(word+" ");
            System.out.println();
        }
    }
}
