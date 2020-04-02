public class BinaryTree {

    public Node root;

    public BinaryTree() {
    }

    public BinaryTree(int[] tab) {
        for (int i : tab)
            this.put(i);
    }

    public void put(int val) {
        root = put(root, val);
    }

    private Node put(Node x, int val) {
        if (x == null) return new Node(val, 1);
        int cmp = val - x.getVal();
        if (cmp < 0) x.left = put(x.left, val);
        if (cmp > 0) x.right = put(x.right, val);
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }

    //Niestety coś poszło nie tak i postanowiłem wrócić do pierwotnego pomysłu
    /*
    boolean isBST = true;
    public boolean isBST(Node node) {
        int val = node.getVal();
        if (node.left != null) {
            goodNodeLeft(node, val);
            isBST(node.left);
        }
        if (node.right != null) {
            goodNodeRight(node, val);
            isBST(node.right);
        }
        return isBST;
    }

    public void goodNodeLeft(Node node, int val) {
        if (node.left != null) {
            if (node.getVal() > val)
                isBST = false;
            goodNodeLeft(node.left, val);
        }
        if (node.right != null) {
            goodNodeLeft(node.right, val);
        }
        if (node.getVal() > val)
            isBST = false;
    }

    public void goodNodeRight(Node node, int val) {
        if (node.left != null) {
            if (node.getVal() < val)
                isBST = false;
            goodNodeRight(node.left, val);

            if (node.right != null) {
                goodNodeRight(node.right, val);
                if (node.getVal() < val)
                    isBST = false;
            }
        }
    }
    */

    int i=0;
    int[] tab;
    public boolean isBST(BinaryTree tree) {
        tab=new int[tree.root.size];
        if (tree.root.left != null) {
            isBSTprim(tree.root.left);
        }
        tab[i]= tree.root.getVal();
        i++;
        if (tree.root.right != null) {
            isBSTprim(tree.root.right);
        }

        boolean is=true;
        int j;
        for (j = 1; j <tab.length ; j++) {
            System.out.print(tab[j-1]+", ");
            if(tab[j]<=tab[j-1])
                is=false;
        }
        System.out.println(tab[j-1]);
        return is;
    }

    public void isBSTprim(Node x) {
        if (x.left != null) {
            isBSTprim(x.left);
        }
        tab[i]= x.getVal(); i++;
        if (x.right != null) {
            isBSTprim(x.right);
        }
    }
}

