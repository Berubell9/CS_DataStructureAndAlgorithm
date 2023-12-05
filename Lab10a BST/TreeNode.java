public class TreeNode {
    int data;
    TreeNode left, right, parent;

    public TreeNode(int d) {
        data = d;
    }

    @Override
    public String toString() {
        // There are 4 cases no child,
        // left-child-only,
        // right-child-only,
        // and both children
        
        /* your code 6 */
        String s = "";
        s += (left == null) ? null : left.data;
        s += "<-" + data + "->";
        s += (right == null) ? null : right.data;
        return s;
        // no child
    }
}
