public class sort{
    public static void main(String[] args) {
        int a[] = {3,2,6,0,4};
        quickSort(a,0,a.length -1);
        System.out.println("Quick Sort");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+"  ");
        }
        bubbleSort2(a,a.length);
        System.out.println();
        System.out.println("Bubble Sort 2");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+"  ");
        }
        selectionSort(a,a.length);
        System.out.println();
        System.out.println("Selection Sort");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+"  ");
        }
        insertionSort(a,a.length);
        System.out.println();
        System.out.println("Insertion Sort");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+"  ");
        }
    }
    static void bubbleSort2(int a[], int N){
        for(int i=0;i<N;++i){
            boolean is_sorted = true;
            for (int j = 1; j<N-i;++j){
                if (a[j-1]>a[j]){
                    int temp = a[j-1];
                    a[j-1]=a[j];
                    a[j]=temp;
                    is_sorted = false;
                }
            }
            if (is_sorted) return;
        }
    }
    static void selectionSort(int a[], int N){
        for (int i = N-1; i >= 1; --i) {
            int maxIdx = i;
            for (int j = 0; j < i; ++j) {
                if(a[j]>=a[maxIdx]){
                    maxIdx = j;
                }
            }
            int temp = a[maxIdx];
            a[maxIdx]= a[i];
            a[i] = temp;
        }
    }
    static void insertionSort(int a[], int N){
        for(int i = 0; i<N; ++i){
            int next = a[i];
            int j;
            for(j=i-1;j>=0 && a[j]>next; --j){
                a[j+1]=a[j];
            }
            a[j+1]=next;
        }
    }
    static void quickSort(int a[], int low, int high){
        int pivotIdx;
        if(low<high){
            pivotIdx = partition(a,low,high);
            quickSort(a,low,pivotIdx-1);
            quickSort(a,pivotIdx+1,high);
        }
    }
    static void swap(int a[], int i, int m){
        int temp = a[m];
        a[m]= a[i];
        a[i] = temp;
    }
    static int partition(int a[], int i, int j){
        int p = a[i];
        int m = i;
        for(int k = i+1; k<=j;++k){
            if(a[k]<p){
                ++m;
                swap(a,k,m);
            }else{

            }
        }
        swap(a,i,m);
        return m;
    }
}


