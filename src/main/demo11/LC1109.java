package main.demo11;
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
public class LC1109 {
    public static void main(String[] args) {

    }
    public Node connect(Node root){
        if(root == null) return root;
        connectNextRightNode(root.left,root.right);
        return root;
    }
    public void connectNextRightNode(Node nodeLeft,Node nodeRight){
        if(nodeLeft == null || nodeRight == null){
            return;
        }
        nodeLeft.next = nodeRight;
        connectNextRightNode(nodeLeft.left,nodeLeft.right);
        connectNextRightNode(nodeLeft.right,nodeRight.left);
        connectNextRightNode(nodeRight.left,nodeRight.right);
    }
}
