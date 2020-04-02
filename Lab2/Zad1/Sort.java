public class Sort {
    int mergCom;
    int heapCom;
    int mergTab[];
    int heapTab[];

    public Sort(int tab[]) {
        mergTab = mergeSort(copyTab(tab));
        heapTab = heapSort(copyTab(tab));
    }

    //mergeSort
    public int[] mergeSort(int[] tab) {
        mergCom = 0;
        int[] tabTemp = new int[tab.length];
        mergeSort(tab, tabTemp, 0, tab.length - 1);
        mergCom++;
        return tab;
    }

    private void mergeSort(int[] tab, int[] tabTemp, int lo, int hi) {
        mergCom++;
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergCom++;
        mergeSort(tab, tabTemp, lo, mid);
        mergeSort(tab, tabTemp, mid + 1, hi);
        merge(tab, tabTemp, lo, mid, hi);
    }

    private void merge(int[] tab, int[] tabTemp, int lo, int mid, int hi) {
        mergCom++;//(k=lo)
        for (int k = lo; k <= hi; k++) {
            mergCom++; //(k <= hi)
            tabTemp[k] = tab[k];
            mergCom++;
        }
        int i = lo, j = mid + 1;
        mergCom += 2;
        mergCom++;//(k=lo)
        for (int k = lo; k <= hi; k++) {
            mergCom++;//(k <= hi)
            if (i > mid) {
                tab[k] = tabTemp[j++];
                mergCom += 2; //(1*if+przypisanie)
            } else if (j > hi) {
                tab[k] = tabTemp[i++];
                mergCom += 3; //(2*if+przypisanie)
            } else if (less(tabTemp[j], tabTemp[i])) {
                tab[k] = tabTemp[j++];
                mergCom += 4; //(3*if+przypisanie)
            } else {
                tab[k] = tabTemp[i++];
                mergCom += 5; //(4*if+przypisanie)
            }
        }
    }

    private boolean less(int a, int b) {
        mergCom++;
        if (a < b)
            return true;
        else
            return false;
    }

    //heapSort
    public int[] heapSort(int[] tab) {
        heapCom = 0;
        int n = tab.length;
        heapCom++;
        heapCom++;//(k=n)
        for (int k = n / 2; k >= 1; k--) {
            heapCom++;//(k >= 1)
            moveDown(tab, k, n);
        }
        int k = n;
        heapCom++;
        heapCom++;//jedno sprawdzenie więcej niż wykonań pętli
        while (k > 1) {
            heapCom++;
            swap(tab, 1, k--);
            moveDown(tab, 1, k);
        }
        return tab;
    }

    private void moveDown(int[] tab, int k, int n) {
        heapCom++;//jedno sprawdzenie więcej niż wykonań pętli
        while (2 * k <= n) {
            heapCom++;
            int j = 2 * k;
            heapCom++;
            heapCom++;
            if (j < n && less(tab, j, j + 1)) {
                j++;
            }
            if (!less(tab, k, j))
                break;
            swap(tab, k, j);
            k = j;
            heapCom++;
        }
    }

    private boolean less(int[] pq, int i, int j) {
        heapCom++;
        if (pq[i - 1] < (pq[j - 1]))
            return true;
        else
            return false;
    }

    private void swap(int[] tab, int i, int j) {
        int swap = tab[i - 1];
        tab[i - 1] = tab[j - 1];
        tab[j - 1] = swap;
        heapCom += 3;
    }

    public int[] copyTab(int[] tab) {
        int[] ret = new int[tab.length];
        for (int i = 0; i < tab.length; i++) {
            ret[i] = tab[i];
        }
        return ret;
    }

    public String showDetails() {
        String ret = "";
        ret += "Ilość operacji porównań i przypisań w:" +
                "\nmergeSort: " + mergCom +
                "\nheapSort: " + heapCom +
                "\n";
        return ret;
    }

    public String showTab(int[] tab) {
        String ret = "";
        for (int x : tab) {
            ret += (x + ", ");
        }
        return ret.substring(0, ret.length() - 2);
    }
}
