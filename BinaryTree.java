public class BinaryTree {

    private Node root;

    public BinaryTree(){}

    public BinaryTree(int[] tab){
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

/*
    public int min() {
        return min(root).getVal();
    }
    private Node min(Node x) {
        if (x.left == null) return x;
        else return min(x.left);
    }
    public int max() {
        return max(root).getVal();
    }
    private Node max(Node x) {
        if (x.right == null) return x;
        else return max(x.right);
    }
*/

/*
    public void deleteMax() {
        if (isEmpty()) throw new
                NoSuchElementException("Tabela symboli jest pusta!");
        root = deleteMax(root);
    }
    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMin() {
        if (isEmpty()) throw new
                NoSuchElementException("Tabela symboli jest pusta!");
        root = deleteMin(root);
    }
    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
*/


//Część budująca i zwracająca Stringa od najmniejszej do największej wartości
    String ret = "";

    public String show() {
        if(size()==0){
            return "Pustoooooo";
        }
        if (root.left != null) {
            show(root.left);
        }
        ret += root.getVal() + ", ";
        if (root.right != null) {
            show(root.right);
        }
        return ret.substring(0, ret.length() - 2); //-2, obcina ", " z końca stringa
    }

    public void show(Node x) {
        if (x.left != null) {
            show(x.left);
        }
        ret += x.getVal() + ", ";
        if (x.right != null) {
            show(x.right);
        }
    }
}
