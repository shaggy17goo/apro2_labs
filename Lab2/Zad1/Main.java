
public class Main {

    public static void main(String[] args) {
        Sort sort1_1 = new Sort(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        Sort sort1_2 = new Sort(new int[]{5, 1, 2, 6, 8, 4, 3, 7, 0, 9});
        Sort sort1_3 = new Sort(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
        System.out.println("Posortowane tablice:" +
                "\nHeapSort: "+sort1_2.showTab(sort1_1.mergTab)+
                "\nMergeSort"+sort1_2.showTab(sort1_1.heapTab));
        System.out.println("Posortowana - " + sort1_1.showDetails());
        System.out.println("Random - " + sort1_2.showDetails());
        System.out.println("Odwrotnie - " + sort1_3.showDetails());



        Sort sort2_1 =new Sort(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,
                31,32,33,34,35, 36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,
                66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100});

        Sort sort2_2 =new Sort(new int[]{33,14,5,96,34,61,41,78,76,40,17,68,75,57,97,84,7,24,31,85,10,80,72,6,3,37,16,91,
                51,1,13, 35,44,89,47,18,30,94,15,92,95,38,9,55,25,53,73,26,82,86,23,67,27,64,43,28,54,77,46,8,4,83,63,21,
                11,93,58, 56,74,71,65,100,69,48,99,81,59,22,2,90,98,88,87,39,29,49,70,36,62,20,32,19,45,50,42,60,66,79,52,12});

        Sort sort2_3 =new Sort(new int[]{1,10,100,11,12,13,14,15,16,17,18,19,2,20,21,22,23,24,25,26,27,28,29,3,30,31,32,33,
                34,35, 36,37,38,39,4,40,41,42,43,44,45,46,47,48,49,5,50,51,52,53,54,55,56,57,58,59,6,60,61,62,63,64,65,66,
                67,68,69,7,70,71,72,73,74,75,76,77,78,79,8,80,81,82,83,84,85,86,87,88,89,9,90,91,92,93,94,95,96,97,98,99});
        System.out.println("Posortowane tablice:" +
                "\nHeapSort: "+sort2_2.showTab(sort2_2.mergTab)+
                "\nMergeSort: "+sort2_2.showTab(sort2_2.heapTab));
        System.out.println("Posortowana " + sort2_1.showDetails());
        System.out.println("Random " + sort2_2.showDetails());
        System.out.println("Kilka błędów - " + sort2_3.showDetails());



    }
}

