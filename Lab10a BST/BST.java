public class BST {
    /* ---------------------------- Task1 ---------------------------- */
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
                        /* your code 1*/
                        cur.left = new TreeNode(d);
                        cur.left.parent = cur;
                        return;
                    }
                } else { // ! (d < p.data)
                    if (cur.right != null)
                        /* your code 2*/
                        cur = cur.right;
                    else {
                        cur.right = new TreeNode(d);
                        cur.right.parent = cur;
                        return;
                    }
                }
            } // while
        }
    } // insert by iteration

    private void printPreOrderRecurse(TreeNode node) {
        /* your code 3*/
        if (node == null)
            return;
        System.out.printf("%d ", node.data);
        printPreOrderRecurse(node.left);
        printPreOrderRecurse(node.right);
    }
    
     public void printPreOrder() {
        printPreOrderRecurse(root);
    }
/* ---------------------------- Task2 ---------------------------- */
 private void printInOrderRecurse(TreeNode node) {
        /* your code 4 */
        if (node == null)
            return;
        printInOrderRecurse(node.left);
        System.out.printf("%d ", node.data);
        printInOrderRecurse(node.right);
    }

    public void printPostOrder() {
        printPostOrderRecurse(root);
    }

    private void printPostOrderRecurse(TreeNode node) {
        /* your code 5 */
        if (node == null)
            return;
        printPostOrderRecurse(node.left);
        printPostOrderRecurse(node.right);
        System.out.printf("%d ", node.data);
    }
/* ---------------------------- Task3 ---------------------------- */
    public TreeNode search(int d) {
        TreeNode result = searchRecurse(d, root);
        return result;
    }

    public TreeNode searchRecurse(int d, TreeNode n) {
        if (n == null)
            return null;
        if (d == n.data)
            return n;
        /* your code 7 */
        if (d > n.data)
            return searchRecurse(d, n.right);
        else
            return searchRecurse(d, n.left);
    }
/* -------------------------------------------------------- */
    public TreeNode searchIter(int key) {
        if (root.data == key)
            return root;
        TreeNode current = root;
        while (current != null) {
            if (key < current.data) {
                if (current.left != null)
                    current = current.left;
                else
                    return null;
            } else {
                if (current.right != null)
                    current = current.right;
                else
                    return null;
            }
            if (current.data == key)
                return current;
            /* your code 8 */
        } // while
        return null;
    }

    public void printInOrder() {
        printInOrderRecurse(root);
    }

   
}
