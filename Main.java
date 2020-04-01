import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random=new Random();
        int randomTab[]=new int[1000];
        for(int i=0; i<1000; i++)
            randomTab[i]=random.nextInt(10000);

        BinaryTree balanced=new BinaryTree(randomTab);
        System.out.println(balanced.show());

        int sortedTab[] =new int[1000];
        for(int i=0; i<1000; i++)
            sortedTab[i]=i;
        BinaryTree unbalanced =new BinaryTree(sortedTab);
        System.out.println(unbalanced.show());

        BinaryTree test1=new BinaryTree();
        System.out.println(test1.show());

        BinaryTree test2 =new BinaryTree(new int[]{});
        System.out.println(test2.show());
        System.out.println(test2.isEmpty());

    }

}
