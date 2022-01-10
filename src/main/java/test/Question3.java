package test;

import java.util.*;

public class Question3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Network network = new Network();
        for (int i = 0; i < n; i++) {
            String command = in.nextLine();
            String[] arguments = command.split(" ");
            switch (arguments[0]) {
                case "Append":
                    network.add(Integer.parseInt(arguments[1]), arguments[2]);
                    break;
                case "Sort":
                    network.sort();
                    break;
                case "Eliminate":
                    network.eliminate(Integer.parseInt(arguments[1]), Integer.parseInt(arguments[2]));
                    break;
                case "Move":
                    network.move(Integer.parseInt(arguments[1]), Integer.parseInt(arguments[2]));
                    break;
                case "Delete":
                    network.delete(arguments[1]);
                    break;
            }
        }

        String name = in.nextLine();
        if (!network.contains(name)) {
            System.out.println(-1);
        } else {
            System.out.println(network.query(name));
        }
    }
}

class Network {
    int access;
    String accessId;
    List<Node> nodes;
    Map<String, Node> nodeMap;

    public Network() {
        this.access = 0;
        this.accessId = "";
        this.nodes = new ArrayList<>();
        this.nodeMap = new HashMap<>();
    }

    public boolean contains(String name) {
        return this.nodeMap.containsKey(name);
    }

    public void add(int delay, String name) {
        Node newNode = new Node(name, delay);
        if (this.nodes.isEmpty()) {
            accessId = name;
        }
        this.nodes.add(newNode);
        this.nodeMap.put(name, newNode);
    }

    public void sort() {
        Collections.sort(nodes, (a, b) -> a.delay - b.delay);
        access = nodes.indexOf(nodeMap.get(accessId));
    }

    public void move(int direction, int pos) {
        if (direction == 0) {
            access += pos;
            access %= nodes.size();
        } else {
            access -= pos;
            access %= nodes.size();
            if (access < 0) {
                access += nodes.size();
            }
        }
        accessId = nodes.get(access).Name;
    }

    public void eliminate(int count, int num) {
        if (num >= nodes.size()) {
            this.access = 0;
            this.accessId = "";
            this.nodes = new ArrayList<>();
            this.nodeMap = new HashMap<>();
        }
        int cur = (access + count - 1) % nodes.size();
        while (num != 0) {
            delete(nodes.get(cur).Name);
            cur = (cur + count - 1) % nodes.size();
            num--;
        }
    }

    public void delete(String name) {
        if (contains(name)) {
            if (accessId.equals(name)) {
                move(0, 1);
            }
            Node node = nodeMap.get(name);
            nodes.remove(node);
            nodeMap.remove(name);
            access = nodes.indexOf(nodeMap.get(accessId));
        }
    }

    public int query(String name) {
        int cur = access, total = 0;
        while (true) {
            Node node = nodes.get(cur);
            if (node.Name.equals(name)) {

                return total;
            } else {
                total += node.delay;
                System.out.println(node.Name);
                cur = (cur + 1) % nodes.size();
            }

        }
    }
}

class Node {
    String Name;
    int delay;

    public Node(String name, int delay) {
        this.Name = name;
        this.delay = delay;
    }
}

/*
题目描述
本题首先需要输入一批操作命令来构建一个环形网络，例如图1展示了执行样例输入各操作命令后环形网络的构建情况，然后输入一个指定网络节点的标识，请问从网络接入点到指定的网络节点中间所经过的网络节点列表，以及总的网络传输延迟？
一个环形网络包含多个网络节点，相邻的网络节点之间只能按顺时针方向进行单向的信号传输。每个网络节点具有两个属性，一是每个节点具有唯一的“网络标识”，由6个小写字母组成；二是信号经过每个节点时，会有一定的“传输延迟”，由一个正整数表示。初始时环形网络为空。
对于一个环形网络，我们定义了如下5种操作命令：
(1)添加（Append）：如果网络为空，添加一个节点并将其作为接入点；否则在当前接入点所在的网络节点“逆时针”方向添加一个相邻的节点，并保持接入点位置不变。如命令“Append 1 nameaa”表示添加一个传输延迟为1，网络标识为“nameaa”的节点。
(2)剔除（Eliminate）：以接入点所在的网络节点为1开始朝顺时针方向计数，每计到第m个节点就将其从当前网络中剔除，然后由下一个节点重新计数，直至剔除出n个网络节点为止（n小于网络中节点的数量）。若剔除的网络节点为接入点，则将顺时针方向的下一个网络节点设为接入点。如“Eliminate m n”表示剔除计数为m的n个网络节点。
(3)移动（Move）：将接入点朝顺时针或者逆时针方向移动r个节点，r是一个正整数。如“Move 0 3”表示将接入点按顺时针方向移动3个节点。其中第一个数字“0”表示移动方向，0表示顺时针方向（1表示逆时针方向）；第二个数字“3”表示移动的节点数目。
(4)排序（Sort）：将环形网络中网络节点按传输延迟由小到大排序，若传输延迟相同，则按节点网络标识的字典序排列。新的接入点仍指向排序前的网络节点。
(5)删除（Delete）：从环形网络中删除一个指定网络标识的节点。当指定网络标识的节点不存在时，则不执行任何操作；当删除的节点为接入点时，则将接入点顺时针方向第一个节点作为新的接入点；当删除网络中剩余的最后一个节点时，则把接入点置空。如“Delete namebb”表示删除环形网络中网络标识为“namebb”的网络节点。
注意：所有网络节点的网络标识都不相同，但网络传输延迟可以相同。

输入描述
第一行一个整数T，表示命令数量。(1 <= T <= 1000)
接下来的T行，每行输入一个命令。
最后一行输入一个网络标识id，表示需要查询的网络节点。

输出描述
输出一行或者多行。如果最终环形网络为空或指定查询网络标识对应的节点不在环形网络中，则输出“-1”；如果查询的节点就是接入点，则输出“0”；否则按序输出接入点到指定网络标识节点之间经过网络节点的网络标识列表（每行输出一条），以及总的传输延迟。

样例输入
8
Append 1 nameaa
Append 3 bbbbbb
Append 5 aabbcc
Append 4 abcdef
Sort
Eliminate 2 1
Move 0 1
Delete nameaa
aabbcc

样例输出
abcdef
4

注释
* */
