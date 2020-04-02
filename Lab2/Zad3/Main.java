import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Main {
    public static void main(String[] args) {
        Random random=new Random();
        int[]tab =new int[10000];
        for (int i = 0; i <10000 ; i++) {
            tab[i]=random.nextInt(1000000);
        }
        BinaryTree tree0=new BinaryTree(tab);
        System.out.println(tree0.isBST(tree0));


        //poprawne drzewo
        BinaryTree tree1 =new BinaryTree(new int[]{5,2,7,3,8,1,6});
        System.out.println(tree1.isBST(tree1));

        //niepoprawne drzewo zależność rodzic-dzieci
        BinaryTree tree2 =new BinaryTree(new int[]{5,2,7,3,8,1,6});
        tree2.root.left.setRight(new Node(99,0));
        System.out.println(tree2.isBST(tree2));

        //duplikat - podwójna 8
        BinaryTree tree3 =new BinaryTree(new int[]{5,2,7,3,8,1,6});
        tree3.root.right.setLeft(new Node(8,0));
        System.out.println(tree3.isBST(tree3));
    }
}
