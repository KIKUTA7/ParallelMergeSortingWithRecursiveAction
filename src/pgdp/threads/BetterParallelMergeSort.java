package pgdp.threads;

import java.util.concurrent.RecursiveAction;

public class BetterParallelMergeSort extends RecursiveAction {
    private Comparable [] array;
    public BetterParallelMergeSort(Comparable[] array) {
       this.array = array;
    }
    
    @Override
    protected void compute() {
        if(array.length >= 15000) {


                Comparable [] array1 = new Comparable[array.length/2];
                Comparable [] array2 = new Comparable[array.length - array.length/2];


                for (int i=0;i<= array.length/2 - 1;i++)
                    array1[i] = array[i];
                for (int i= array.length/2;i<= array.length - 1;i++)
                    array2[i - array.length/2] = array[i];


                BetterParallelMergeSort par1 = new BetterParallelMergeSort(array1);
                BetterParallelMergeSort par2 = new BetterParallelMergeSort(array2);


                invokeAll(par1,par2);

                for (int i=0;i<= array.length/2 - 1;i++)
                    array[i] = array1[i] ;
                for (int i= array.length/2;i<= array.length - 1;i++)
                    array[i] = array2[i - array.length/2];



                MergeSort.merge(array,new Comparable[array.length],0,array.length/2 - 1,array.length - 1);
            }
        else
        {
            MergeSort.mergesort(array);
        }
    }

    public static void main(String[] args) {
        Integer hah [] = new Integer[] {3,7,1,9,8,5,10,1,4,7,8,9,16,4,6};
        new BetterParallelMergeSort(hah).compute();
        for (int i = 0; i < hah.length; i++) {
            System.out.print(hah[i] + " " );
        }
    }
}
