//Facebook, Amazon, Bloomberg, Google, Microsoft, Pinterest

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Node[] copyNodes = new Node[100];
        return dfs(node, copyNodes);
    }
    private Node dfs(Node node, Node[] copyNodes)
    {
        if(node == null) return null;

        int index = node.val - 1;
        if(copyNodes[index] == null)
        {
            copyNodes[index] = new Node(node.val);
            for(Node neighbor : node.neighbors)
                copyNodes[index].neighbors.add(dfs(neighbor, copyNodes));
        }
        return copyNodes[index];
    }
}
