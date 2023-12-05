import code.*;

class BST {

    TreeNode root;

    public BST() {
        root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void insert(int d) {
        if (root == null) {
            root = new TreeNode(d);
        } else {
            TreeNode cur = root;
            while (cur != null) {
                if (d < cur.data) {
                    if (cur.left != null)
                        cur = cur.left;
                    else {
                        /* your code 1 */
                        cur.left = new TreeNode(d);
                        cur.left.parent = cur;
                        return;
                    }
                } else { // ! (d < p.data)
                    if (cur.right != null)
                        /* your code 2 */cur = cur.right;

                    else {
                        cur.right = new TreeNode(d);
                        cur.right.parent = cur;
                        return;
                    }
                }
            } // while
        }
    } // insert by iteration

    public void printInOrder() {
        printInOrderRecurse(root);
        System.out.println();
    }

    private void printInOrderRecurse(TreeNode node) {
        if (node == null)
            return;
        printInOrderRecurse(node.left);
        System.out.print(node.data + " ");
        printInOrderRecurse(node.right);
    }

    public TreeNode search(int d) {
        TreeNode result = searchRecurse(d, root);
        return result;
    }

    public TreeNode searchRecurse(int d, TreeNode n) {
        if (n == null)
            return null;
        if (d == n.data)
            return n;
        /* your code 7 */if (d < n.data)
            return searchRecurse(d, n.left);

        return searchRecurse(d, n.right);
    }

    public int height() {
        return root == null ? 0 : height(root);
    }

    public int height(TreeNode node) {
        if (node == null)
            return 0;
        return /* your code 9 */1 + Integer.max(height(node.left), height(node.right));
    }

    public TreeNode findMaxFrom(TreeNode findMaxFrom) {
        /* your code 10 */
        TreeNode current = findMaxFrom.right;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public void delete(int d){
        delete(d, root);
    }

    public void delete(int d, TreeNode current) {
        if (current == null)
            return; // not found
        if (d < current.data)
            delete(d, current.left);
        else if (d > current.data)
            delete(d, current.right);
        else { // found ... time to delete
            if (current.left == null || current.right == null) { // 0 or 1 child
                TreeNode q = (current.left == null) ? current.right : current.left;
                if (current.parent.left == current)
                    current.parent.left = q; // this node is left child
                else
                    current.parent.right = q;
                if (q != null)
                    q.parent = current.parent;
            } else { // two children
                TreeNode q = findMaxFrom(current);
                /* your code 11 */
                if(q.parent != current){
                    q.parent.left = q.right;
                }else{
                    q.parent.right = q.right;
                }
                current.data = q.data;
            } // two children
        } // found
    }
}
