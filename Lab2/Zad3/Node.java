public class Node {
    private int val; // wartosc
    public Node left, right; // lewe i prawe poddrzewo
    public int size; // liczba wezlow wpoddrzewie

    public Node(int val, int size) {
        this.val = val;
        this.size = size;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }
}