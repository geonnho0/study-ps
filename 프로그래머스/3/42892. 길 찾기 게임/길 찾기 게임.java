import java.util.*;

class Solution {
    
    List<Integer> preorder = new ArrayList<>(), postorder = new ArrayList<>();
    
    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        Node[] nodes = new Node[n];
        for (int i = 1; i <= n; i++)
            nodes[i - 1] = new Node(i, nodeinfo[i - 1][0], nodeinfo[i - 1][1]);
        
        Arrays.sort(nodes, (n1, n2) -> {
            if (n1.y == n2.y)
                return n1.x - n2.x;
            return n2.y - n1.y;
        });
        
        for (int i = 1; i < n; i++)
            makeTree(nodes[0], nodes[i]);
        preOrder(nodes[0]);
        postOrder(nodes[0]);
        int[][] answer = new int[2][n];
        for (int i = 0; i < n; i++) {
            answer[0][i] = preorder.get(i);
            answer[1][i] = postorder.get(i);
        }
        return answer;
    }
    
    void makeTree(Node root, Node child) {
        if (root.x > child.x) {
            if (root.left == null) {
                root.left = child;
                return;
            }
            makeTree(root.left, child);
            return;
        }
        if (root.right == null) {
            root.right = child;
            return;
        }
        makeTree(root.right, child);
    }
    
    void preOrder(Node root) {
        preorder.add(root.num);
        if (root.left != null)
            preOrder(root.left);
        if (root.right != null)
            preOrder(root.right);
    }
    
    void postOrder(Node root) {
        if (root.left != null)
            postOrder(root.left);
        if (root.right != null)
            postOrder(root.right);
        postorder.add(root.num);
    }
}

class Node {
    int num, x, y;
    Node left, right;
    
    public Node(int num, int x, int y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }
}