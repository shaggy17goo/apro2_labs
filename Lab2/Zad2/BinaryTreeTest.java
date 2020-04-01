import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    //zbalansowane
    BinaryTree balancedTree = new BinaryTree(new int[] {41,20,65,11,29,50,91,32,72,99});

    //cały czas w lewo
    BinaryTree unbalancedTree = new BinaryTree(new int[] {9,8,7,6,5,4,3,2,1});

    BinaryTree emptyTree=new BinaryTree();

    @org.junit.jupiter.api.Test
    void show() {
        String bal="11, 20, 29, 32, 41, 50, 65, 72, 91, 99";
        String unbal = "1, 2, 3, 4, 5, 6, 7, 8, 9";
        String empty="Pustoooooo";
        assertTrue(bal.equals(balancedTree.show()));
        assertTrue(unbal.equals(unbalancedTree.show()));
        assertTrue(empty.equals(emptyTree.show()));

    }
}