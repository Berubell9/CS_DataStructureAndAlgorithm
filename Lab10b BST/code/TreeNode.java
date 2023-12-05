package code;

public class TreeNode {
    public int data;
    public TreeNode left, right, parent;

    public TreeNode(int d) {
        data = d;
    }

    @Override
    public String toString() {
        /* your code 6 */
        String leftChildString = (left != null) ? String.valueOf(left.data) : "null";
        String rightChildString = (right != null) ? String.valueOf(right.data) : "null";

        return leftChildString+"<-" + data + "->"+rightChildString;
        // no child
    }
}