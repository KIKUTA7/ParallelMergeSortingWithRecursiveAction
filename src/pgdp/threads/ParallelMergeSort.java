package pgdp.threads;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class ParallelMergeSort extends RecursiveAction {
    Comparable[] array ;
    public ParallelMergeSort(Comparable[] array) {
        this.array = array;
    }

    @Override
    protected void compute() {
//        if(array.length % 4 == 0) {
//        if(array.length < 4) {MergeSort.mergesort(array);return;}
//        int quarter = array.length/4;
//        Comparable [] array1 = new Comparable[quarter];
//        Comparable [] array2 = new Comparable[quarter];
//        Comparable [] array3 = new Comparable[quarter];
//        Comparable [] array4 = new Comparable[array.length - 3* quarter];
//
//        for (int i=0;i<= quarter - 1;i++)
//            array1[i] = array[i];
//        for (int i= quarter;i<= 2*quarter - 1;i++)
//            array2[i - quarter] = array[i];
//        for (int i=2*quarter;i<= 3*quarter - 1;i++)
//            array3[i - 2*quarter] = array[i];
//        for (int i=3*quarter;i<= array.length - 1;i++)
//            array4[i - 3*quarter] = array[i];
//
//        ParallelMergeSort par1 = new ParallelMergeSort(array1);
//        ParallelMergeSort par2 = new ParallelMergeSort(array2);
//        ParallelMergeSort par3 = new ParallelMergeSort(array3);
//        ParallelMergeSort par4 = new ParallelMergeSort(array4);
//
//        invokeAll(par1,par2,par3,par4);
//
//        for (int i=0;i<= quarter- 1;i++)
//            array[i] = array1[i] ;
//        for (int i= quarter;i<= 2*quarter - 1;i++)
//            array[i] = array2[i - quarter];
//        for (int i=2*quarter;i<= 3*quarter - 1;i++)
//            array[i] = array3[i - 2*quarter];
//        for (int i=3*quarter;i<= array.length - 1;i++)
//            array[i] = array4[i - 3*quarter];
//
//        MergeSort.merge(array,new Comparable[2*quarter],0,(2*quarter - 1)/2,2*quarter - 1);
//        MergeSort.merge(array,new Comparable[array.length - 2*quarter + 7],2* quarter,
//                (2*quarter + array.length - 1)/2, array.length - 1);
//
//        MergeSort.merge(array,new Comparable[array.length],0,2*quarter - 1 ,array.length - 1); }
//        else
//        {
                    if(array.length < 2) {return;}

                    Comparable [] array1 = new Comparable[array.length/2];
                    Comparable [] array2 = new Comparable[array.length - array.length/2];


                    for (int i=0;i<= array.length/2 - 1;i++)
                        array1[i] = array[i];
                    for (int i= array.length/2;i<= array.length - 1;i++)
                        array2[i - array.length/2] = array[i];


                    ParallelMergeSort par1 = new ParallelMergeSort(array1);
                    ParallelMergeSort par2 = new ParallelMergeSort(array2);


                    invokeAll(par1,par2);

                    for (int i=0;i<= array.length/2 - 1;i++)
                        array[i] = array1[i] ;
                    for (int i= array.length/2;i<= array.length - 1;i++)
                        array[i] = array2[i - array.length/2];



                    MergeSort.merge(array,new Comparable[array.length],0,array.length/2 - 1,array.length - 1);
               // }






    }

    public static void main(String[] args) {
        Integer hah [] = new Integer[] {3,7,1,9,8,5,10,1,4,7,8,9,16,4,6};
        new ParallelMergeSort(hah).compute();
        for (int i = 0; i < hah.length; i++) {
            System.out.print(hah[i] + " " );
        }

    }
}




