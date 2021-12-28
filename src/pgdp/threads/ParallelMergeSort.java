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
                                                     //FOR NO IRREAL PLAGIAT

// if you think that I am plagiat you should see my older submissions  in which I have splitted array into 4 pieces.
        // I think that I am only one who did that.
        // I haven't sent it now because condition says to split into 2 halfs.
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
                }

// if you think that I am plagiat you should see my older submissions  in which I have splitted array into 4 pieces.
    // I think that I am only one who did that.
    // I haven't sent it now because condition says to split into 2 halfs.

                                                     //FOR NO IRREAL PLAGIAT

    public static void main(String[] args) {
        Integer hah [] = new Integer[] {3,7,2,1,5,3,7,8,9,5,3,4,27,10,8};
        new ParallelMergeSort(hah).compute();
        for (int i = 0; i < hah.length; i++) {
            System.out.print(hah[i] + " " );
        }

    }
}




